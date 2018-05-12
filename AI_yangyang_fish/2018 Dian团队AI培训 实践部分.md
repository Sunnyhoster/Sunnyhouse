# 2018 Dian团队AI培训 实践部分

### 编程工具

* python
* [Anaconda](https://www.anaconda.com)
* Jupyter Notebook
* Sublime/Pycharm



### 使用框架

* [Pytorch](http://pytorch.org)
* [TensorFlow](https://www.tensorflow.org)
* [Keras](https://keras.io)

### 常用工具

* [Scikit-learn](http://scikit-learn.org/)

  > [分类](http://sklearn.apachecn.org/cn/0.19.0/supervised_learning.html#supervised-learning):识别某个对象属于哪个类别
  > [回归](http://sklearn.apachecn.org/cn/0.19.0/supervised_learning.html#supervised-learning):预测与对象相关联的连续值属性
  >
  > [聚类](http://sklearn.apachecn.org/cn/0.19.0/modules/clustering.html#clustering):将相似对象自动分组
  >
  > [降维](http://sklearn.apachecn.org/cn/0.19.0/modules/decomposition.html#decompositions):减少要考虑的随机变量的数量
  >
  > [模型选择](http://sklearn.apachecn.org/cn/0.19.0/model_selection.html#model-selection):比较，验证，选择参数和模型
  >
  > [预处理](http://sklearn.apachecn.org/cn/0.19.0/modules/preprocessing.html#preprocessing) :特征提取和归一化

* [Pandas](http://pandas.pydata.org)

* Numpy

* pillow/nltk

![img](https://images0.cnblogs.com/blog2015/561813/201505/281120453768566.png)

### 从零开始写机器学习程序

1. 下载并研究数据。分析数据结构，数据类型，并设计相应的读取数据的方法，构建合适的dataloader。
2. 确定问题类型，是分类，预测，还是其他？搞明白问题类型后，选择一种合适的方法，初步确定要使用的模型，并有针对性的研究它。
3. 搭建一个简单的baseline模型，可以使用默认的各种参数和网上经典的设定，目标是先跑起来，取得一个能用的模型。
4. 写好你的train和test代码，用一小部分数据训练，能够产生正常的输出，正确率也许不高但是不至于低的离谱。如果低的离谱，请自行查bug。
5. 根据你的研究调查调试模型，使用全部训练集反复训练，用测试集测试，直到你得到一个满意的模型。

### 实战讲解

* 天皇GitHub链接：[此処](https://github.com/miracleyou/cs231n_assignment_HUST)
* 数据集：cifar-10



---

天皇より

平成三〇年４月２１日