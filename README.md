# AndroidDaggerDemo

## What is dagger
A fast dependency injector for Android and Java

## 依赖注入
想要了解依赖注入的概念，可以看一看JSR-330标准，里边有对依赖注入最清晰的定义
截取其中的部分概念
```
依赖: 一些类型被另一些类型依赖
class A {
}
class B {
    A a = new A{};
}
B依赖A

解析依赖: 在运行时查找一个依赖实例的过程叫解析依赖
```
## 在依赖注入之前创建对象的几种方式
1.  构造器
2.  工厂
3.  服务定位器

## 依赖注入创建对象方式
通过依赖注入器 inject 传递依赖

## 好处
解耦和方便单元测试，代码可复用,参见软件设计六大原则（单一职责，里氏替换，依赖倒置，接口隔离，迪米特法则，开闭原则）

## 由javax.inject包提供的关于依赖注入的注解
### 声明依赖注解
@Inject  用于标识可注入的构造器，方法，和字段

### 限定器注解
1. @Qualifier 定义一个限定器注解
2. @Named 一个string限定器注解

@Named 是一个有@Qualifier定义的限定器注解
```
@Qualifier
@Documented
@Retention(RUNTIME)
public @interface Named {

    /** The name. */
    String value() default "";
}
```

### 提供者注解
@Provider 

### 作用域注解
@Scope 定义一个作用域注解
@Singleton 单例作用域

@Singleton 是一个由@Scope定义的作用域注解
```
@Scope
@Documented
@Retention(RUNTIME)
public @interface Singleton {}
```

## Dagger是什么？
在了解了依赖注入以后，我们更容易理解dagger的定义

代替 构造器，工厂，服务定位器 ，建立在JSR-330标准之上，使得应用可以轻松创建可重用可互换可测试的模块
与其他依赖注入框架的区别spring,Guice,是第一个通过生成代码实现完整的依赖注入框架

## 如何使用

### 声明依赖关系

class Thermosiphon implements Pump {
  private final Heater heater;

  @Inject
  Thermosiphon(Heater heater) {
    this.heater = heater;
  }

  ...
}

### 满足依赖

@Inject 不能在以下情况下使用
    无法实例化的interface
    第三方类无法被注解
    需要配置的类必须提前被配置好
可以使用@Provides 来实现依赖关系
所有的@Provides方法必须属于一个@Module
按照惯例@Provides方法以provide前缀命名

### 构建依赖图
@Inject和@Provides提供了依赖关系，
通过@Component注解在一个接口类（如CoffeeShop），然后传递module类型给modules参数，Dagger2 将会根据约定生成一个完整的实现

@Component(modules = DripCoffeeModule.class)
interface CoffeeShop {
  CoffeeMaker maker();
}

CoffeeShop coffeeShop = DaggerCoffeeShop.builder()
    .dripCoffeeModule(new DripCoffeeModule())
    .build();