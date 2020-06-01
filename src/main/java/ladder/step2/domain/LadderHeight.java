package ladder.step2.domain;

import ladder.step2.exception.LadderHeightMinimumSizeException;
import ladder.step2.exception.LadderHeightNonNumberException;

import java.util.HashMap;
import java.util.Map;

public class LadderHeight {

  private static final Map<Integer, LadderHeight> FACTORY = new HashMap<>();

  private final int height;

  private LadderHeight (int height) {
    this.height = height;
  }

  public int getValue () {
    return height;
  }

  public static LadderHeight valueOf (String height) {
    validateThatItsNumber(height);
    return valueOf(Integer.parseInt(height));
  }

  public static LadderHeight valueOf (int height) {
    validateHeight(height);
    LadderHeight ladderHeight = FACTORY.get(height);
    if (ladderHeight == null) {
      ladderHeight = new LadderHeight(height);
      FACTORY.put(height, ladderHeight);
    }
    return ladderHeight;
  }

  public static void validateThatItsNumber (String value) {
    try {
      Integer.parseInt(value);
    } catch (Exception e) {
      throw new LadderHeightNonNumberException();
    }
  }

  public static void validateHeight (int height) {
    if (height < 1) {
      throw new LadderHeightMinimumSizeException();
    }
  }
}
