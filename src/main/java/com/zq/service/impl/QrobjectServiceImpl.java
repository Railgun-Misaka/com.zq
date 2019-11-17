package com.zq.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zq.mapper.QrobjectMapper;
import com.zq.pojo.Qrobject;
import com.zq.service.QrobjectService;

@Service
public class QrobjectServiceImpl implements QrobjectService {
	
	@Autowired QrobjectMapper qrobjectMapper ;
	
	public Qrobject get(int id) {
		return qrobjectMapper.get(id);
	}

	public List<Qrobject> list() {
		return qrobjectMapper.list();
	}

	public int add(Qrobject qr) {
		return qrobjectMapper.add(qr);
	}

	public int delete(int id) {
		return qrobjectMapper.delete(id);
	}

	public int update(Qrobject qr) {
		qrobjectMapper.update(qr);
		return qrobjectMapper.release(qr);
	}

}
