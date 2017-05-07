package dao;

import java.util.ArrayList;
import domain.GoodsVo;

public interface GoodsDao {
	public int getPageCount();
	public ArrayList getGoodsByPage(int pageNo);
	public GoodsVo getGoodsById(String goodsId);
}
