package com.els.jewellery.manage.common.node;

public class TreeNode {

	private String id; // 节点id

	private String pId; // 父节点id

	private String name; // 节点名称

	private Boolean open; // 是否打开节点

	private Boolean checked; // 是否被选中

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getOpen() {
		return open;
	}

	public void setOpen(Boolean open) {
		this.open = open;
	}

	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

	public static TreeNode createParent() {
		TreeNode node = new TreeNode();
		node.setpId("0");
		node.setId("0");
		node.setName("顶级");
		node.setOpen(true);
		node.setChecked(true);
		return node;
	}

}
