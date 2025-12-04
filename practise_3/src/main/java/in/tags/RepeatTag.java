package in.tags;

import java.io.IOException;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;

public class RepeatTag extends SimpleTagSupport {
    private int times;

    public void setTimes(int times) { this.times = times; }

    @Override
    public void doTag() throws JspException, IOException{
        if(getJspBody() != null){
            for(int i=0; i<times; i++){
                getJspBody().invoke(null);
            }
        }
    }
}
