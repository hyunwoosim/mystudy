package wooapp.menu;

import wooapp.util.AnsiEscape;
import wooapp.util.Prompt;

public abstract class AbstractMenuHandler implements wooapp.menu.MenuHandler {


  protected Menu menu;

  @Override
  public void action(Menu menu, Prompt prompt) {
    this.printMenuTitle(menu.getTitle(),prompt);
    this.menu = menu;
    this.action(prompt);
  }

  private void printMenuTitle(String title, Prompt prompt) {
    System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, title);
  }

  // 서브 클래스가 구현해야 할 메서드이다.
  // 수퍼 클래스의 action(Menu)을 실행할 때 호출되는 메서드이다.
  // 외부에서 호출할 메서드가 아니다.
  // 따라서 접근 범위를 서브 클래스에서 접근할 수 있도록 제한한다.
  protected abstract void action(Prompt prompt);
}
