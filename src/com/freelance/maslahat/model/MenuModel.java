package com.freelance.maslahat.model;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

public class MenuModel {

	private static Map<String, MenuModel> menu = new HashMap<String, MenuModel>();
	
	private String namaMenu;
	private String idMenu;
	
	private String create;
	private String read;
	private String update;
	private String delete;
	private String exportToPdf;
	private String exportToExcel;
	private String download;
	private String upload;
	
	//enhancement (untuk link slider)
	private String url;
	
	public String getDownload() {
		return download;
	}

	public void setDownload(String download) {
		this.download = download;
	}

	public String getUpload() {
		return upload;
	}

	public void setUpload(String upload) {
		this.upload = upload;
	}

	public boolean haveCreate() {
		if (StringUtils.isNotEmpty(create) && create.equals("true"))
			return true;
		return false;
	}
	
	public boolean haveRead() {
		if (StringUtils.isNotEmpty(read) && read.equals("true"))
			return true;
		return false;
	}
	
	public boolean haveUpdate() {
		if (StringUtils.isNotEmpty(update) && update.equals("true"))
			return true;
		return false;
	}
	
	public boolean haveDelete() {
		if (StringUtils.isNotEmpty(delete) && delete.equals("true"))
			return true;
		return false;
	}
	
	public boolean haveExpToExcel() {
		if (StringUtils.isNotEmpty(exportToExcel) && exportToExcel.equals("true"))
			return true;
		return false;
	}
	
	public boolean haveExpToPdf() {
		if (StringUtils.isNotEmpty(exportToPdf) && exportToPdf.equals("true"))
			return true;
		return false;
	}
	
	
	public boolean haveDownload() {
		if (StringUtils.isNotEmpty(download) && download.equals("true"))
			return true;
		return false;
	}
	
	public boolean haveUpload() {
		if (StringUtils.isNotEmpty(upload) && upload.equals("true"))
			return true;
		return false;
	}
	
//	public static List<String> listRole(String userId) {
//		List<String> list = new ArrayList<String>();
//		RoleAccessService service = new RoleAccessService();
//		Map<String, RoleAccess> mapRoles = service.mapRoleAccess("BY_USER_ID", userId);
//		for (Map.Entry<String, RoleAccess> entry : mapRoles.entrySet()) {
//			if (entry.getValue().haveRead()) {
//				String key = entry.getKey();
//				list.add(key);
//			}
//		}
//		return list;
//	}
//	
//	public static Map<String, RoleAccess> listRoles(String userId) {
//		RoleAccessService service = new RoleAccessService();
//		Map<String, RoleAccess> mapRoles = service.mapRoleAccess("BY_USER_ID", userId);
//		for (Map.Entry<String, RoleAccess> entry : mapRoles.entrySet()) {
//			if (entry.getValue().haveRead()) {
//				String key = entry.getKey();
//				RoleAccess roles = entry.getValue();
//				menu.put(key, roles);
//			}
//		}
//		return menu;
//	}
//	
//	public static void generate(String userId, String userName) {
//		ActionContext context = ActionContext.getContext();
//		RoleAccessService service = new RoleAccessService();
//		Map<String, RoleAccess> mapRoles = service.mapRoleAccess("BY_USER_ID", userId);
//		LOG.info("List of roles ["+userName+"]\n");
//		for (Map.Entry<String, RoleAccess> entry : mapRoles.entrySet()) {
//			if (entry.getValue().haveRead()) {
//				String key = entry.getKey();
//				RoleAccess roles = entry.getValue();
//				menu.put(key, roles);
//				context.put(key, roles);
//				LOG.info(Function.toString(context.get(key)));
//			}
//		}
//		ActionContext.setContext(context);
//	}
//	
//	public static void clear() {
//		menu.clear();
//	}
//	
	public MenuModel(String menuKey, String menuName, String action) {
		this.idMenu = menuKey;
		this.namaMenu = menuName;
		//System.out.println("action "+menuKey+" = "+action);
		if (action != null) {
			create = convertCharacter(action, 0);
			read = convertCharacter(action, 2);
			update = convertCharacter(action, 4);
			delete = convertCharacter(action, 6);
			exportToPdf = convertCharacter(action, 8);
			exportToExcel = convertCharacter(action, 10);
			upload = convertCharacter(action, 12);
			download = convertCharacter(action, 14);
		}
//		LOG.info(Function.toString(this));
	}
	
	public MenuModel() {}

	public String toEmpty() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 7; i++) {
			sb.append(convertStatus(null));
		}
//		LOG.info(sb);
		return sb.toString();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(convertStatus(this.create));
		sb.append(convertStatus(this.read));
		sb.append(convertStatus(this.update));
		sb.append(convertStatus(this.delete));
		sb.append(convertStatus(this.exportToPdf));
		sb.append(convertStatus(this.exportToExcel));
		sb.append(convertStatus(this.upload));
		sb.append(convertStatus(this.download));
		
//		LOG.info(sb);
		return sb.toString();
	}
	
	private String convertStatus(String status) {
		//System.out.println("status= "+status);
		if (StringUtils.isNotEmpty(status) && status.equals("on"))
			return "1;";
		return "0;";
	}
	
	
	private String convertCharacter(String str, int index) {
		try {
			char c = str.charAt(index);
			if (c == '1')
				return "true";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "false";
	}

	public String getCreate() {
		return create;
	}

	public void setCreate(String create) {
		this.create = create;
	}

	public String getRead() {
		return read;
	}

	public void setRead(String read) {
		this.read = read;
	}

	public String getUpdate() {
		return update;
	}

	public void setUpdate(String update) {
		this.update = update;
	}

	public String getDelete() {
		return delete;
	}

	public void setDelete(String delete) {
		this.delete = delete;
	}

	public String getExportToPdf() {
		return exportToPdf;
	}

	public void setExportToPdf(String exportToPdf) {
		this.exportToPdf = exportToPdf;
	}

	public String getExportToExcel() {
		return exportToExcel;
	}

	public void setExportToExcel(String exportToExcel) {
		this.exportToExcel = exportToExcel;
	}
	
	public static void clear() {
		menu.clear();
	}
	
	public String getNamaMenu() {
		return namaMenu;
	}
	public void setNamaMenu(String namaMenu) {
		this.namaMenu = namaMenu;
	}
	public String getIdMenu() {
		return idMenu;
	}
	public void setIdMenu(String idMenu) {
		this.idMenu = idMenu;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
