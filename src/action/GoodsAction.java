package action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import domain.GoodsVo;
import service.GoodsService;

import com.opensymphony.xwork2.ActionSupport;
import dao.GoodsDao;
import dao.impl.GoodsDaoImpl;

@Scope("prototype")
@Controller("goodsAction")
public class GoodsAction extends ActionSupport{
	
	private final static Logger log = Logger.getLogger(GoodsAction.class);
	
	@Resource(name="goodsService")
	private GoodsService goodsService;
	
    private int pageNo = 1;
    private int pageCount;
    private List<GoodsVo> goodsList;
    
    public String findAllGoods() throws Exception{
		goodsList = goodsService.getGoodsByPage(pageNo);
		pageCount = goodsService.getPageCount();
    	return SUCCESS;
    }
    
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public List<GoodsVo> getGoodsList() {
		return goodsList;
	}
	public void setGoodsList(List<GoodsVo> goodsList) {
		this.goodsList = goodsList;
	}
}
