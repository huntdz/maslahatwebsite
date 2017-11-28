package com.freelance.maslahat.action;

/*import id.co.git.mandiri.model.MarketUpdate;
import id.co.git.mandiri.model.MenuTabModel;
import id.co.git.mandiri.model.Slider;
import id.co.git.mandiri.services.MarketUpdateService;
import id.co.git.mandiri.services.RoleManagementService;
import id.co.git.mandiri.services.SliderService;*/

import com.freelance.maslahat.model.MenuModel;
import com.freelance.maslahat.service.RoleManagementService;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LandingPageAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	String roleId;
	//private List<MarketUpdate> overview;
	

	//private List<MarketUpdate> listMarketUpdate;
	//private List<Slider> sliderList;
	private int sizeList;
	/**
	 * load data aplication first time
	 * @return
	 */
	public String landingPage(){
		roleId = String.valueOf(ActionContext.getContext().getSession().get("id_role"));
		System.out.println("roleId : "+roleId);
		//loadMarketWrap();
		//loadReksadana();
		int sessSize = ActionContext.getContext().getSession().size();
		System.out.println("session size = " + sessSize);
		if(sessSize <= 2 ){
			System.out.println("no login");
			ActionContext.getContext().getSession().clear();
			ActionContext.getContext().getSession().put("user", "guest");
			ActionContext.getContext().getSession().put("id_role", "2");
			//ActionContext.getContext().getSession().put("is_guest", "Y");
			roleId = "2";
			setRoleAccess(roleId);
			//setRoleTabAccess(roleId);
			//loadMarketWrap();
			//loadSlider();
		}
		return SUCCESS;
	}
	
	/*public String loadMarketWrap(){
		MarketUpdateService service = new MarketUpdateService();
		setOverview(service.view("VIEW ALL"));
		loadReksadana();
		loadSlider();
		return SUCCESS;
	}*/
	
	/*public String loadReksadana(){
		
		MarketUpdateService service = new MarketUpdateService();
		setListMarketUpdate(service.viewScoringReksadanaTable("VIEW ALL"));
		return SUCCESS;		
	}*/	
	
	/*public void loadSlider(){
		SliderService service = new SliderService();
		setSliderList(service.view("VIEW ALL"));
		setSizeList(getSliderList().size());
		System.out.println(getSizeList());
	}*/
	/**
	 * set role action for guest user
	 * @param idUserLevel
	 */
	protected void setRoleAccess(String idRole){
		Map<String, MenuModel> mapRoles = new RoleManagementService().roleMenuAccess(idRole);
		for (Map.Entry<String, MenuModel> entry : mapRoles.entrySet()) {
			if (entry.getValue().haveRead()) {
				String key = entry.getKey();
				MenuModel role = entry.getValue();
				ActionContext.getContext().getSession().put(key, role);
			}
			//System.out.println("session size di setRoleAccess : "+ActionContext.getContext().getSession().size());
		}
	}

	/**
	 * set role action for guest user
	 * @param idUserLevel
	 */
	/*protected void setRoleTabAccess(String idRole){
		Map<String, MenuTabModel> mapRoles = new RoleManagementService().roleTabMenuAccess(idRole);
		for (Map.Entry<String, MenuTabModel> entry : mapRoles.entrySet()) {
			if (entry.getValue().haveRead()) {
				String key = entry.getKey();
				MenuTabModel role = entry.getValue();
				ActionContext.getContext().getSession().put(key, role);
			}
		}
	}*/

	/*public List<MarketUpdate> getOverview() {
		return overview;
	}

	public void setOverview(List<MarketUpdate> overview) {
		this.overview = overview;
	}

	public List<MarketUpdate> getListMarketUpdate() {
		return listMarketUpdate;
	}

	public void setListMarketUpdate(List<MarketUpdate> listMarketUpdate) {
		this.listMarketUpdate = listMarketUpdate;
	}

	public List<Slider> getSliderList() {
		return sliderList;
	}

	public void setSliderList(List<Slider> sliderList) {
		this.sliderList = sliderList;
	}*/

	public int getSizeList() {
		return sizeList;
	}

	public void setSizeList(int sizeList) {
		this.sizeList = sizeList;
	}
	
	
	
}
