package com.example.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson02.dao.UsedGoodsDAO;
import com.example.lesson02.model.UsedGoods;

@Service 
public class UsedGoodsBO {
	
	@Autowired // 다오에 new를 통해 선언을 해야하는데 @Autowired를 통해 바로 만들어 준다. 
	private UsedGoodsDAO usedGoodsDAO;
	
	// 또 다른 spring been을 가져올때 @Autowired는 꼭붙어있어야한다. (객체마다 하나씩 가지고있어야한다.)
	public List<UsedGoods> getUsedGoodsList() { // get+클래스명+사용객체로 쓰는게 관래적
		return usedGoodsDAO.selectUsedGoodsList();
	}
}
