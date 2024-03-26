package bitcamp.myapp.vo;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data // = @Getter + @Setter + @ToString + @EqualsAndHashCode + @RequiredArgsConstructor
public class Assignment implements Serializable {

    private static final long serialVersionUID = 100L;

    private int no;
    private String title;
    private String content;
    private Date deadline;

}
