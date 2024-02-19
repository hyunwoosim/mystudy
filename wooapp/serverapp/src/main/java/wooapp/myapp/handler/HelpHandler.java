package wooapp.myapp.handler;

import wooapp.menu.AbstractMenuHandler;
import wooapp.util.Prompt;

public class HelpHandler extends AbstractMenuHandler {



  @Override
  protected void action( Prompt prompt) {
    System.out.println("도움말입니다.");
  }
}
