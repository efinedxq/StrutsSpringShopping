package service.impl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.GoodsDao;
import domain.GoodsVo;
import service.GoodsService;

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {
    
	@Resource(name="goodsDao")
	private GoodsDao goodsDao;

	@Override
	public int getPageCount() {
		// TODO Auto-generated method stub
		return goodsDao.getPageCount();
	}

	@Override
	public ArrayList getGoodsByPage(int pageNo) {
		// TODO Auto-generated method stub
		return goodsDao.getGoodsByPage(pageNo);
	}

	@Override
	public GoodsVo getGoodsById(String goodsId) {
		// TODO Auto-generated method stub
		return goodsDao.getGoodsById(goodsId);
	}
	
}
