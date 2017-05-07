package service;

import java.util.ArrayList;

import domain.GoodsVo;

public interface GoodsService {
	public int getPageCount();
	public ArrayList getGoodsByPage(int pageNo);
	public GoodsVo getGoodsById(String goodsId);
}
