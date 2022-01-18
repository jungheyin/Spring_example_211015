package com.example.lesson02.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.lesson02.model.UsedGoods;

@Repository // 어노테이션 명이 다 다름 또 없으면 에러가 난다.
public interface UsedGoodsDAO {

	public List<UsedGoods> selectUsedGoodsList();
}
