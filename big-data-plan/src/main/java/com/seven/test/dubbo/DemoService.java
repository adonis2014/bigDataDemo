package com.seven.test.dubbo;
public interface DemoService {
	
    public void sayHello();
    
    public String returnHello();
    
    public MsgInfo returnMsgInfo(MsgInfo info);
    
}