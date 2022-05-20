# BUAA-SE-OOP-CTS
这是北航软件学院面向对象OOP迭代式大作业CTS（铁路管理系统）的代码。具体需求内容在Request文件夹中，程序入口在APP.java中

程序结构：

│  Test.java
├─application
│      App.java
│      Global.java
│      
├─behavior
│  │  ErrorBehavior.java
│  │  LineListBehavior.java
│  │  QuitBehavior.java
│  │  TrainListBehavior.java
│  │  UserListBehavior.java
│  │  
│  └─role
│          CertBehavior.java
│          LineBehavior.java
│          TrainBehavior.java
│          UserBehavior.java
│          
├─controller
│  ├─role
│  │      CertController.java
│  │      LineListController.java
│  │      TrainListController.java
│  │      UserController.java
│  │      UserListController.java
│  │      
│  └─terminal
│          DefaultController.java
│          SudoController.java
│          
├─entity
│  ├─line
│  │      Line.java
│  │      LineList.java
│  │      Station.java
│  │      
│  ├─order
│  │      Order.java
│  │      OrderInfo.java
│  │      OrderList.java
│  │      
│  ├─train
│  │      Seat.java
│  │      SeatType.java
│  │      Train.java
│  │      TrainList.java
│  │      TrainType.java
│  │      
│  └─user
│          Cert.java
│          LoginUser.java
│          Student.java
│          User.java
│          UserList.java
│          Wallet.java
│          
├─terminal
│      Default.java
│      Sudo.java
│      TerminalType.java
│      
└─utils
  regexTest.java
  Str.java
