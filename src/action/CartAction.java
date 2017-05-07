package action;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import bean.CartManager;
import domain.Item;

@Scope("prototype")
@Controller("cartAction")
public class CartAction extends ActionSupport {
	
	private final static Logger log = Logger.getLogger(CartAction.class);
	
	private String goodsId;
	private ArrayList<Item> cart;
	private int quantity;
	@Resource(name="cartManager")
    private CartManager cartManager;
	public String addToCart() {
		
		log.debug("goodsId_"+goodsId+" quantity_"+quantity);
		
		ActionContext ctx = ActionContext.getContext();
		// session不会自动注入，需要用一下方式，手动获取
		// 界面可以直接写cart来获取
		cart = (ArrayList<Item>) ctx.getSession().get("cart");
//		CartManager cartManager = new CartManager();
		
		if (cart != null) {
			cartManager.setCart(cart);
			cartManager.addToCart(goodsId, 1);
		} else {
			cart = new ArrayList<Item>();
			cartManager.setCart(cart);
			cartManager.addToCart(goodsId, 1);
		}
		ctx.getSession().put("cart", cartManager.getCart());
		return SUCCESS;
	}

	public String clearCart() {
		ActionContext ctx = ActionContext.getContext();
		ctx.getSession().remove("cart");
		return SUCCESS;
	}

	public String modifyGoods() {
		
		log.debug("goodsId_"+goodsId+" quantity_"+quantity);
		
		ActionContext ctx = ActionContext.getContext();
		// session不会自动注入，需要用一下方式，手动获取
		// 界面可以直接写cart来获取
		cart = (ArrayList<Item>) ctx.getSession().get("cart");
//		CartManager cartManager = new CartManager();
		cartManager.setCart(cart);
		cartManager.update(goodsId, quantity);

		ctx.getSession().put("cart", cartManager.getCart());
		return SUCCESS;
	}

	public String deleteGoods() {
		
		log.debug("goodsId_"+goodsId+" quantity_"+quantity);
		
		ActionContext ctx = ActionContext.getContext();
		// session不会自动注入，需要用一下方式，手动获取
		// 界面可以直接写cart来获取
		cart = (ArrayList<Item>) ctx.getSession().get("cart");
//		CartManager cartManager = new CartManager();
		cartManager.setCart(cart);
		cartManager.delete(goodsId);
		
		ctx.getSession().put("cart", cartManager.getCart());
		return SUCCESS;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public ArrayList<Item> getCart() {
		return cart;
	}

	public void setCart(ArrayList<Item> cart) {
		this.cart = cart;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
