package com.tyron.builder.compiler.manifest.resources;

/**
 * Keyboard enum.
 *
 * <p>This is used in the manifest in the uses-configuration node and in the resource folder names.
 */
public enum Keyboard implements ResourceEnum {
  NOKEY("nokeys", null, "No Keys", "No keyboard"), // $NON-NLS-1$
  QWERTY("qwerty", null, "Qwerty", "Qwerty keyboard"), // $NON-NLS-1$
  TWELVEKEY("12key", "twelvekey", "12 Key", "12 key keyboard"); // $NON-NLS-1$ //$NON-NLS-2$
  private final String mValue, mValue2;
  private final String mShortDisplayValue;
  private final String mLongDisplayValue;

  Keyboard(String value, String value2, String shortDisplayValue, String longDisplayValue) {
    mValue = value;
    mValue2 = value2;
    mShortDisplayValue = shortDisplayValue;
    mLongDisplayValue = longDisplayValue;
  }

  /**
   * Returns the enum for matching the provided qualifier value.
   *
   * @param value The qualifier value.
   * @return the enum for the qualifier value or null if no matching was found.
   */
  public static Keyboard getEnum(String value) {
    for (Keyboard kbrd : values()) {
      if (kbrd.mValue.equals(value) || (kbrd.mValue2 != null && kbrd.mValue2.equals(value))) {
        return kbrd;
      }
    }

    return null;
  }

  @Override
  public String getResourceValue() {
    return mValue;
  }

  @Override
  public String getShortDisplayValue() {
    return mShortDisplayValue;
  }

  @Override
  public String getLongDisplayValue() {
    return mLongDisplayValue;
  }

  public static int getIndex(Keyboard value) {
    return value == null ? -1 : value.ordinal();
  }

  public static Keyboard getByIndex(int index) {
    Keyboard[] values = values();
    if (index >= 0 && index < values.length) {
      return values[index];
    }
    return null;
  }

  @Override
  public boolean isFakeValue() {
    return false;
  }

  @Override
  public boolean isValidValueForDevice() {
    return true;
  }
}
