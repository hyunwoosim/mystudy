package bitcamp.myapp.handler.assignment;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.Dao.AssignmentDao;
import bitcamp.myapp.vo.Assignment;
import bitcamp.util.Prompt;

public class AssignmentAddHandler extends AbstractMenuHandler {

    private AssignmentDao assignmentDao;


    public AssignmentAddHandler(AssignmentDao assignmentDao, Prompt prompt) {
        super(prompt);
        this.assignmentDao = assignmentDao;
    }

    @Override
    protected void action() {

        Assignment assignment = new Assignment();
        assignment.setTitle(this.prompt.input("과제명? "));
        assignment.setContent(this.prompt.input("내용? "));
        assignment.setDeadline(this.prompt.inputDate("제출 마감일?(예: 2023-12-25) "));

        assignmentDao.add(assignment);


    }
}
