package in.tags;

import java.io.IOException;

import jakarta.servlet.jsp.tagext.SimpleTagSupport;

public class TableTag extends SimpleTagSupport {
    private int row;
    private int col;

    public void setRow(int row) { this.row = row; }
    public void setCol(int col) { this.col = col; }

    @Override
    public void doTag() throws IOException{
        var out = getJspContext().getOut();
        out.println("<table border='1'>");
        for(int r=1; r<=row; r++){
            out.println("<tr>");
            for(int c=1; c<=col; c++){
                out.println("<td>Cell "+ r + "," + c + "</td>");
            }
            out.println("</tr>");
        }
        out.println("</table>");
    }
}
