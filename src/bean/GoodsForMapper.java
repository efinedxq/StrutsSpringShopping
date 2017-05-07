package bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.tree.TreePath;

import org.springframework.jdbc.core.RowMapper;

import domain.GoodsVo;

public class GoodsForMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet arg0, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		GoodsVo g = new GoodsVo();
		g.setGoodsId(arg0.getString("goodsid"));
		g.setGoodsName(arg0.getString("goodsname"));
		g.setPrice(arg0.getFloat("price"));
		return g;
	}

}
