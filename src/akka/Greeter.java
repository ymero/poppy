/**
 * s * @项目名称: poppyHaveFun
 * 
 * @文件名称: Greeter.java
 * @Date: 2015-2-11
 * @Copyright: 2015-2015 www.neunn.com All rights reserved. 注意：本内容仅限于东网科技有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
package akka;

import akka.actor.UntypedActor;



/**
 * akka测试类
 * 
 * @author Poppy
 * @date 2015-2-11
 * @since 1.0
 */
public class Greeter extends UntypedActor {

    // Msg（枚举类型）
    public static enum Msg {
        GREET, DONE
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
        if (msg == Msg.GREET) {
            // 如果接收到的消息是一个Greeter.Msg.GREET，打印Hello World。
            System.out.println("Greeting!");
            // 停下（stop）所有的处理
            getSender().tell(Msg.DONE, getSelf());
        } else {
            // 没处理
            unhandled(msg);
        }
    }

}
