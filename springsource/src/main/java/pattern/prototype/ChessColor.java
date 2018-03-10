package pattern.prototype;

/**
 * 棋子颜色
 */
public enum ChessColor {
    WHITE("白色"),
    BLACK("黑色");

    private String name = null;

    private ChessColor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
