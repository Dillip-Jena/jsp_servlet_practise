package in.tags;

import java.io.IOException;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;

public class IsEven extends SimpleTagSupport {
    private int number;

    public void setNumber(int number){
        this.number = number;
    }

    @Override
    public void doTag() throws JspException, IOException{
        boolean isEven = (number %2 == 0);

        if(isEven){
            if(getJspBody() != null){
                getJspBody().invoke(null);
            }
        }
    }
}
