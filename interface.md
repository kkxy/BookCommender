#  用户部分

##  OK_登录

url: /login

data: {	

​	username:<String>,

​	password:<String>

}

returnData: null

## OK_注册

url: /register

data: {

​	username: <String>,

​	password: <String>

}

returnData: {

​	username: <String>

}



## OK_登出 

url: /logout

data: null

returnData: null



# 书籍部分

## OK_首页

url:/index

data: {

​	classtype: \<String> (ab, bc)

}

returnData: {

​	bigclass:  [\<Dict>],

​	smallclass:[\<Dict>],

​	booklist : [\<Book\>]

}

## OK_搜索

url: /search

data: {

​	itemname: \<String>

​	seachtype: \<String>(author, book)

}

returnData: {

​	booklist : [\<Book\>]

}

## OK_书籍详情

url: /bookdetail

data: {

​	bookid: \<Integer>

}

returnData:{

​	 bookdetail: \<Book>

}

##  OK_心愿单

url: /wishcart

data: {

​	bookid: \<int> 

}

returnData: {

​	purchasebook: \<Book>

​	commendbook: [\<Book>]	

​	relatebook:[\<Book>]

}

## OK_个人中心部分

url: /usercenter

data:null

returnData: {

​	buylist:[\<Book>]

}



