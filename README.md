# 我的淘宝

本项目是对淘宝进行的仿写项目。项目实现了类似淘宝的登录注册界面UI、首页商品展示、消息界面UI、购物车管理、用户个人中心UI。

## 登录、注册界面

启动应用后会先进入登录界面：

<img src="https://raw.githubusercontent.com/xiaoduyyy/pictures/main/image-20241117181108635.png" alt="image-20241117181108635" style="zoom: 50%;" />

通过对EditText进行监听，对Button的状态进行修改（当EditText中有内容，Button才能点击），这里主要只是仿写了UI，随便输入什么信息都可以进行登录。

下面的协议的点击事件使用了ClickableSpan，对text的部分区域设置了点击事件进行页面跳转。

![01cfb23d262f9bf4a83c14fc5501a228](https://raw.githubusercontent.com/xiaoduyyy/pictures/main/01cfb23d262f9bf4a83c14fc5501a228.gif)

在登录界面点击**立即跳转**可以进入注册界面（也是只仿写了UI）：

<img src="https://raw.githubusercontent.com/xiaoduyyy/pictures/main/image-20241117182237275.png" alt="image-20241117182237275" style="zoom:50%;" />

## 首页

首页顶部是一个AppBarLayout，内部有Toolbar。在标题栏下部是一个TabLayout，与下面的Viewpager2进行了绑定。

![d3081b49e1dc405909c7de7600bca928](https://raw.githubusercontent.com/xiaoduyyy/pictures/main/d3081b49e1dc405909c7de7600bca928.gif)

在Viewpager2里的Fragment的顶部还有一个Viewpager2，两者之间存在滑动冲突。由于Viewpager2不能继承，我通过自定义了一个MyView嵌套在了内部Viewpager2的外部，设置了触摸拦截，解决了两者间的滑动冲突。

Fragment里最外层是ConstraintLayout，内部使用了NestedScrollView包裹了整个部分，内部含有上面说过的Viewpager2、CircleIndicator3（和Viewpager2进行了绑定）、ImageView、和用于展示商品的RecyclerView。

对商品设置了点击事件，可以跳转商品详情页：

![b84ace81d5c9056f837dd9b55be741db](https://raw.githubusercontent.com/xiaoduyyy/pictures/main/b84ace81d5c9056f837dd9b55be741db.gif)

## 商品详情页

商品详情页最外层为ConstraintLayout，最上边是Banner轮播图，在轮播图上面设置了几个透明按钮。通过给外层嵌套了NestedScrollView实现了整体界面的滚动。

详情页可以进行收藏（只可点击）与加入购物车（主要功能），在向下滑动一定距离后，会显示隐藏的顶部标题栏与回到顶部悬浮按钮：

![67e86aa852bed8d1f6525a4f7cb939a9](https://raw.githubusercontent.com/xiaoduyyy/pictures/main/67e86aa852bed8d1f6525a4f7cb939a9.gif)

## 消息界面

消息界面主要是仿写了UI，下方整体使用了NestedScrollView进行滑动，顶部有一个RecyclerView：

![415e1959d890c9df4bb1e39766c1e3f3](https://raw.githubusercontent.com/xiaoduyyy/pictures/main/415e1959d890c9df4bb1e39766c1e3f3.gif)

## 购物车

添加商品前：

<img src="https://raw.githubusercontent.com/xiaoduyyy/pictures/main/ccee09b3a2fd7458c8390aa07a9c4bfb.jpg" alt="ccee09b3a2fd7458c8390aa07a9c4bfb" style="zoom:50%;" />

添加商品后：

<img src="https://raw.githubusercontent.com/xiaoduyyy/pictures/main/75e882aa590769be6b3befb0066d5973.jpg" alt="75e882aa590769be6b3befb0066d5973" style="zoom:50%;" />

购物车的商品展示部分是一个RecyclerView，当RecyclerView里没有数据的时候显示购物车为空的图片。

可以对购物车里的商品进行选中购买、全选、增加减少数量：

![b1b162281a96d08e54e3d53e9899b398](https://raw.githubusercontent.com/xiaoduyyy/pictures/main/b1b162281a96d08e54e3d53e9899b398.gif)

通过点击商品的数量按钮可以显示增加减少数量的按钮，在增加减少完成后可以通过滑动RecyclerView隐藏增加减少商品数量的布局。

## 个人信息界面

个人信息界面也是主要实现了UI仿写：

![d44a37287a912dc63d8dcb9d62e44077](https://raw.githubusercontent.com/xiaoduyyy/pictures/main/d44a37287a912dc63d8dcb9d62e44077.gif)

最外层是NestedScrollView，然后使用约束布局实现了上面的信息部分，猜你喜欢下方也是RecyclerView。

