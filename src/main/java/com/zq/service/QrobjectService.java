package com.zq.service;

import java.util.List;

import com.zq.pojo.Qrobject;

public interface QrobjectService {
	
	public Qrobject get(int id) ;
	
	public List<Qrobject> list();
	
	public int add(Qrobject qr);
	
	public int delete(int id);
	
	public int update(Qrobject qr);
}
