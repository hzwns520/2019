### Git 学习总结

#### 1使用git需要做的最小配置

1 git config —local(—global) 范围 —unset(取消) —add(增加) user.name "huangzhengwei" user.emal "xxx"

#### 2 工作区和暂存区

使用git add 后会到暂存区



#### 3 日志查看方法 重命名

git mv KNN/kNN.py KNN/kNN1.py

git log --oneline -2 --graph

—oneline 一行展示 -2 表示只展示最近几次提交

gitk 图形化展示



#### 4 探秘.git目录

cat HEAD
ref: refs/heads/master

HEAD 记录的是当前处于那一个分支

Objects 目录下存放的是数据地方

可以通过git cat-file查看文件 -t 是查看文件类型 -p 查看具体问题内容

git cat-file -t 18f5b168a

git cat-file -p 18f5b168a

Refs 记录的是分支

cat master

每个分支记录的就是一个commit

git cat-file -t a48139c8e4f0
commit
huangzhengwei@huangzhengweideMacBook-Pro:~/git_learning/.git/refs/heads%
huangzhengwei@huangzhengweideMacBook-Pro:~/git_learning/.git/refs/heads%
huangzhengwei@huangzhengweideMacBook-Pro:~/git_learning/.git/refs/heads%
huangzhengwei@huangzhengweideMacBook-Pro:~/git_learning/.git/refs/heads% git cat-file -p a48139c8e4f0
tree b865c0093d4a5048ea420f36ec9533a6dabe5a3b
parent 55412dad71fdac35abf68da5843109db1a79e7da
author hzwns <526933759@qq.com> 1553496840 +0800
committer hzwns <526933759@qq.com> 1553496840 +0800

一个commit 会对应着一个tree

huangzhengwei@huangzhengweideMacBook-Pro:~/git_learning/.git/refs/heads% git cat-file -p b865c0093d4
040000 tree 958164f7e4fc444f53a8aebfda688b6efc8499e8	KNN
040000 tree 4b0e7095fc88f82529faee0771ff6f37dee7bf65	images
100644 blob e69de29bb2d1d6434b8b29ae775ad8c2e48c5391	index.html
100644 blob e69de29bb2d1d6434b8b29ae775ad8c2e48c5391	readme
040000 tree 39d978686d1e836b3fd676c9e29c7f7a58e82432	style
huangzhengwei@huangzhengweideMacBook-Pro:~/git_learning/.git/re

一个tree 下面会记录多个 tree  blob

**总结** git对象类型有3种 commit  tree blob

一次commit 中包含 一个tree 和一些提交的信息 一个 tree 中包含了这一次提交的内容， 其中包含了 tree 和blob blob 指的是文件内容，**注意** git中如果文件内容相同那么只会有一个blob

#### 5 分离头指针

**detached** **HEAD**

分离头指针简单的讲就是当前的一次提交没有指向任何一个分支

#### 6 怎么删除不需要的分支



#### 7 对比暂存区的数据

- git diff —cached 比较暂存区和最新一次提交的差异
- git diff 比较工作区和暂存区的差别
- git diff HEAD 比较工作区和最新一次提交的差别
- git diff commitID 比较工作区和某一次提交的差别
- git diff —cached commitid 比较暂存区和某一次提交的差别

#### 8 对文件的修改回滚

git reset  让暂存区的数据和HEAD保持一致

git checkout 将 工作区和暂存区保持一致

- 如果暂存区没有文件变化，那么就是和HEAD保持一致
- 如果暂存区有文件变化，就是和暂存区保持一致

