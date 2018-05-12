# 论文阅读报告（LightGBM: A Highly Efficient Gradient Boosting Decision Tree）

---

GBDT，对于每个特征需要去扫描整个数据集得到分割点，当特征维度很高或者数据量很大时，这个过程是非常耗时的。

--->

两种解决方法：基于梯度的one-side采样和互斥的特征捆绑。对于**GOSS**，我们排除了一部分梯度值小的数据实例，仅仅使用剩下来评估信息增益。这样做可行性的原因，拥有梯度值大的数据集在信息增益计算时扮演更重要的角色。在小数据集上GOSS可以获得更加准确的信息增益的评估结果。**EFB**捆绑互斥的特征，来减少特征的数量。但是我们发现最优的互斥特征是一个NP难问题，贪心算法可以取得近似的分数（在不损害分割点方向准确率的情况下，有效减少特征值）。

--->

Algorithm 1: **Histogram-based Algorithm**
Input: I: training data, d: max depth
Input: m: feature dimension
nodeSet ← {0} . tree nodes in current level
rowSet ← {{0, 1, 2, ...}} . data indices in tree nodes
for i = 1 to d do
for node in nodeSet do
usedRows ← rowSet[node]
for k = 1 to m do
H ← new Histogram()
. Build histogram
for j in usedRows do
bin ← I.f[k][j].bin
H[bin].y ← H[bin].y + I.y[j]
H[bin].n ← H[bin].n + 1
Find the best split on histogram H.
...
Update rowSet and nodeSet according to the best
split points.
...
Algorithm 2: **Gradient-based One-Side Sampling**
Input: I: training data, d: iterations
Input: a: sampling ratio of large gradient data
Input: b: sampling ratio of small gradient data
Input: loss: loss function, L: weak learner
models ← {}, fact ← 1−a
b
topN ← a × len(I) , randN ← b × len(I)
for i = 1 to d do
preds ← models.predict(I)
g ← loss(I, preds), w ← {1,1,...}
sorted ← GetSortedIndices(abs(g))
topSet ← sorted[1:topN]
randSet ← RandomPick(sorted[topN:len(I)],
randN)
usedSet ← topSet + randSet
w[randSet] × = fact . Assign weight f act to the
small gradient data.
newModel ← L(I[usedSet], − g[usedSet],
w[usedSet])
models.append(newModel)

Algorithm 3: **Greedy Bundling**
Input: F : features, K: max conflict count
Construct graph G
searchOrder ← G.sortByDegree()
bundles ← {}, bundlesConflict ← {}
for i in searchOrder do
needNew ← True
for j = 1 to len(bundles) do
cnt ← ConflictCnt(bundles[j],F [i])
if cnt + bundlesConflict[i] ≤ K then
bundles[j].add(F [i]), needNew ← False
break
if needNew then
Add F [i] as a new bundle to bundles
Output: bundles
Algorithm 4: **Merge Exclusive Features**
Input: numData: number of data
Input: F : One bundle of exclusive features
binRanges ← {0}, totalBin ← 0
for f in F do
totalBin += f.numBin
binRanges.append(totalBin)
newBin ← new Bin(numData)
for i = 1 to numData do
newBin[i] ← 0
for j = 1 to len(F ) do
if F [j].bin[i] 6= 0 then
newBin[i] ← F [j].bin[i] + binRanges[j]
Output: newBin, binRanges

--->

为了减少训练数据量，常规的方法是降低采样数据实例。例如，过滤掉权重值小于阈值的数据。SGB使用随机子集训练弱弱学习器，采样比率动态调整，有部分基于Adboost，不能直接应用于GBDT，因为在GBDT没有初始的权重。虽然SGB可以应用于GBDT，当时通过这种方式会损失准确度,和采取降低数据的方法相似，自然想到的是过滤掉对于算法影响弱的特征。通常通过降维的方法，例如**主成分分析**或者**投影法**，这种降维的方法依赖假设-特征中有冗余，但是这不符合实际，每一维的特征都有其表征，取出任何特征都可能有损精度。在真实应用场景中，数据通常是稀疏的，使用**预排序的GBDT**通过忽略为零的特征降低训练特征。然而基于直方图的GBDT没有有效的稀疏优化方案。直方图的算法需要检索特征本值，无论特征值是否为零。基于直方图的GBDT能够有效利用如此的稀疏特性。

--->

实验结果是与理论一致并表明，在GOSS和EFB的帮助下，LightGBM可以显着提高在计算速度和内存消耗方面优于XGBoost和SGB。我们将研究基于渐变的单面采样中a和b的最优选择并且继续提高专有特征捆绑的性能来处理大量的功能无论他们稀疏与否。

