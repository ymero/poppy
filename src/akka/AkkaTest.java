/**
 * @项目名称: poppy
 * @文件名称: AkkaTest.java
 * @Date: 2015-2-11
 * @Copyright: 2015-2015 www.neunn.com All rights reserved. 注意：本内容仅限于东网科技有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
package akka;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

/**
 * akka测试类，将akka当jar包用的时候，需要导入三个jar包：akka-actor_2.10.jar，config.jar，scala-libray.jar。
 * 
 * @author Poppy
 * @date 2015-2-11
 * @since 1.0
 */
public class AkkaTest {

    public static void main(String[] args) {
        System.out.println("start!");
        ActorSystem system = ActorSystem.create("MySystem");
        // 创建hello实例
        ActorRef hello = system.actorOf(Props.create(HelloWorld.class), "hello");
        // 通过tell方法给hello发送消息
        hello.tell(Greeter.Msg.GREET, hello);
    }

}
