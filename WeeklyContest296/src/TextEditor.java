/**
 * Your TextEditor object will be instantiated and called as such:
 * TextEditor obj = new TextEditor();
 * obj.addText(text);
 * int param_2 = obj.deleteText(k);
 * String param_3 = obj.cursorLeft(k);
 * String param_4 = obj.cursorRight(k);
 */

class TextEditor {
    private StringBuffer currentText;
    private int cursor;

    public TextEditor() {
        currentText = new StringBuffer();
        cursor = 0;
    }

    public void addText(String text) {
        currentText.insert(cursor, text);
        cursor += text.length();
    }

    public int deleteText(int k) {
        int numToDelet = Integer.min(cursor, k);
        currentText.delete(cursor - numToDelet, cursor);
        cursor -= numToDelet;
        return numToDelet;
    }

    public String cursorLeft(int k) {
        cursor = Integer.max(cursor - k, 0);
        int offset = Integer.min(cursor, 10);
        return currentText.substring(cursor - offset, cursor);
    }

    public String cursorRight(int k) {
        cursor = Integer.min(cursor + k, currentText.length());
        int offset = Integer.min(cursor, 10);
        return currentText.substring(cursor - offset, cursor);
    }

    public String getCurrentText() {
        return currentText.substring(0, cursor) + '|' + currentText.substring(cursor);
    }
}
