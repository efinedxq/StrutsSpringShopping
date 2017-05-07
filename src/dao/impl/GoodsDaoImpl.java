package dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import bean.DBBean;
import bean.GoodsForMapper;
import dao.GoodsDao;
import domain.GoodsVo;

@Repository("goodsDao")
public class GoodsDaoImpl implements GoodsDao {

	@Resource(name = "dataSource")
	private DataSource dataSource;

	private JdbcTemplate jdbcTemplate;

	public void init() {
		if (jdbcTemplate == null) {
			jdbcTemplate = new JdbcTemplate(dataSource);
		}
	}

	private int numPerPage = 3;

	@Override
	public int getPageCount() {
		// TODO Auto-generated method stub
		init();
		int rst = 0;
		String sql = "select count(*) from goods";
		rst = jdbcTemplate.queryForObject(sql, Integer.class);
		return (rst - 1) / numPerPage + 1;
	}

	@Override
	public ArrayList getGoodsByPage(int pageNo) {
		// TODO Auto-generated method stub
		init();

		ArrayList rst = new ArrayList();

		String sql = "select * from goods";
//		rst = (ArrayList)jdbcTemplate.queryForList(sql, new Object[]{pageNo*numPerPage,numPerPage},new GoodsForMapper());
		DBBean db = new DBBean();
		Connection con = db.getConnection();
		ResultSet rs = null;

		try {
			rs = db.executeQuery(sql, null);

			if (rs != null) {
				int index = 1;
				int beginIndex = (pageNo - 1) * numPerPage + 1;
				int endIndex = pageNo * numPerPage;
				// 这里不需要判断endIndex是否超出了结果数量，如果endIndex超出时rs.next就跳出循环了
				while (rs.next()) {
					if (index < beginIndex) {
						index++;
						continue;
					}

					if (index > endIndex) {
						break;
					}

					String goodsId = rs.getString(1);
					String goodsName = rs.getString(2);
					Float price = rs.getFloat(3);

					GoodsVo g = new GoodsVo();
					g.setGoodsId(goodsId);
					g.setGoodsName(goodsName);
					g.setPrice(price);

					rst.add(g);
					index++;
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rst;
	}

	@Override
	public GoodsVo getGoodsById(String goodsId) {
		// TODO Auto-generated method stub
		init();
		GoodsVo g = null;
		String sql = "select * from goods where goodsid=?";
		g = (GoodsVo) jdbcTemplate.queryForObject(sql,new Object[]{goodsId}, new GoodsForMapper());
		
//		
//		ArrayList rst = new ArrayList();
//		ArrayList params = new ArrayList();
//		params.add(goodsId);
//
//		DBBean db = new DBBean();
//		Connection con = db.getConnection();
//		ResultSet rs = null;
//
//		try {
//			rs = db.executeQuery(sql, params);
//			if (rs != null) {
//
//				rs.next();
//
//				String goodsId_ = rs.getString(1);
//				String goodsName = rs.getString(2);
//				Float price = rs.getFloat(3);
//
//				g = new GoodsVo();
//				g.setGoodsId(goodsId_);
//				g.setGoodsName(goodsName);
//				g.setPrice(price);
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return g;
	}

}
