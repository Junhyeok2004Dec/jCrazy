package util;

public class Attribute {
	private String type;
	private String value;

	public Attribute(String type, String value) {
		this.type = type;
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "Attribute{" +
				"type='" + type + '\'' +
				", value='" + value + '\'' +
				'}';
	}
}
