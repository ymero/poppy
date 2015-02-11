/**
 * @项目名称: poppyHaveFun
 * @文件名称: HelloWorld.java
 * @Date: 2015-2-11
 * @Copyright: 2015-2015 www.neunn.com All rights reserved. 注意：本内容仅限于东网科技有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
package akka;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;


/**
 * akka测试类，这个HelloWorld继承了UntypedActor，表明我们实现的是一个Actor。
 * 
 * @author Poppy
 * @date 2015-2-11
 * @since 1.0
 */
public class HelloWorld extends UntypedActor {


    /**
     * preStart是在启动这个Actor时调用的方法
     * 
     * @author Poppy
     * @date 2015-2-11
     * @since 1.0
     */
    @Override
    public void preStart() {
        // 创建greeter实例
        final ActorRef greeter = getContext().actorOf(Props.create(Greeter.class), "greeter");
        // 用tell方法给greeter发送消息
        greeter.tell(Greeter.Msg.GREET, getSelf());
    }

    /**
     * onReceive方法处理我们接收到消息的情况
     * 
     * @author Poppy
     * @date 2015-2-11
     * @param arg0
     * @throws Exception
     * @since 1.0
     */
    @Override
    public void onReceive(Object msg) throws Exception {
        if (msg == Greeter.Msg.DONE) {
            System.out.println("HelloWorld!");
            // 如果接收到的消息是一个Greeter.Msg.DONE，停下（stop）所有的处理
            getContext().stop(getSelf());
        } else {
            // 没处理
            unhandled(msg);
        }
    }

}
