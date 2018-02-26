package jsonconvert;

public class Chart {
	
	String caption;
	String subCaption;
	String xAxisname;
	String yAxisName;
	String showSum;
	String numberPrefix;
	String theme;
	
	public Chart(String caption, String subCaption, String xAxisnams, String yAxisName,String showSum, String numberPrefix, String theme)
	{
		this.caption=caption;
		this.subCaption=subCaption;
		this.xAxisname=xAxisnams;
		this.yAxisName=yAxisName;
		this.showSum=showSum;
		this.numberPrefix=numberPrefix;
		this.theme=theme;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public String getSubCaption() {
		return subCaption;
	}
	public void setSubCaption(String subCaption) {
		this.subCaption = subCaption;
	}
	public String getxAxisname() {
		return xAxisname;
	}
	public void setxAxisname(String xAxisname) {
		this.xAxisname = xAxisname;
	}
	public String getyAxisName() {
		return yAxisName;
	}
	public void setyAxisName(String yAxisName) {
		this.yAxisName = yAxisName;
	}
	public String getShowSum() {
		return showSum;
	}
	public void setShowSum(String showSum) {
		this.showSum = showSum;
	}
	public String getNumberPrefix() {
		return numberPrefix;
	}
	public void setNumberPrefix(String numberPrefix) {
		this.numberPrefix = numberPrefix;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	

}
