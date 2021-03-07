package com.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

@SuppressWarnings("unused")
@Service
public interface ServiceExam2<E> {

	public void insert(E element);

	public List<E> listAll();

	public void delete(Integer id);

}
