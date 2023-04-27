package com.igor.feedbacker.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.igor.feedbacker.entities.Feedbacks;
import com.igor.feedbacker.repositories.FeedbacksRepository;
import com.igor.feedbacker.services.interfaces.FeedbacksServicesInterface;

@Service
public class FeedbacksServiceImpl implements FeedbacksServicesInterface {

	@Autowired
	private FeedbacksRepository feedbacksRepo;

	@Override
	@PreAuthorize("isAuthenticated()")
	public Map<String, Object> buscarTodosPorId(String id) {
		List<Feedbacks> feedbackList = feedbacksRepo.findByUserId(id);
		List<Map<String, Object>> resultList = new ArrayList<>();
		for (Feedbacks feedback : feedbackList) {
			Map<String, Object> resultMap = new HashMap<>();
			resultMap.put("text", feedback.getText());
			resultMap.put("fingerprint", feedback.getFingerprint());
			resultMap.put("id", feedback.getId());
			resultMap.put("apiKey", feedback.getApiKey());
			resultMap.put("type", feedback.getType());
			resultMap.put("device", feedback.getDevice());
			resultMap.put("page", feedback.getPage());
			resultList.add(resultMap);
		}
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("results", resultList);
		Map<String, Integer> paginationMap = new HashMap<>();
		paginationMap.put("offset", 0);
		paginationMap.put("limit", resultList.size());
		paginationMap.put("total", feedbackList.size());
		resultMap.put("pagination", paginationMap);
		return resultMap;

	}

	@Override
	@PreAuthorize("isAuthenticated()")
	public Feedbacks novoFeedback(Feedbacks obj) {
		Feedbacks usr = feedbacksRepo.save(obj);
		return feedbacksRepo.save(usr);
	}

	@Override
	@PreAuthorize("hasRole('ADMIN')")
	public void deletarFeedback(String id) {
		buscaPorId(id);
		feedbacksRepo.deleteById(id);

	}

	@Override
	@PreAuthorize("isAuthenticated()")
	public Optional<Feedbacks> buscaPorId(String id) {
		Optional<Feedbacks> obj = feedbacksRepo.findById(id);
		return obj;
	}

	@Override
	@PreAuthorize("isAuthenticated()")
	public Map<String, Object> buscarPorTipo(String tipo, String id) {
		List<Feedbacks> feedbackList = feedbacksRepo.findByTypeContainsAndId(tipo.toUpperCase(), id);
		List<Map<String, Object>> resultList = new ArrayList<>();
		for (Feedbacks feedback : feedbackList) {
			Map<String, Object> resultMap = new HashMap<>();
			resultMap.put("text", feedback.getText());
			resultMap.put("fingerprint", feedback.getFingerprint());
			resultMap.put("id", feedback.getId());
			resultMap.put("apiKey", feedback.getApiKey());
			resultMap.put("type", feedback.getType());
			resultMap.put("device", feedback.getDevice());
			resultMap.put("page", feedback.getPage());
			resultList.add(resultMap);
		}
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("results", resultList);
		Map<String, Integer> paginationMap = new HashMap<>();
		paginationMap.put("offset", 0);
		paginationMap.put("limit", resultList.size());
		paginationMap.put("total", feedbackList.size());
		resultMap.put("pagination", paginationMap);
		return resultMap;
	}

	@Override
	public Map<String, Object> buscarTodos() {
		List<Feedbacks> feedbackList = feedbacksRepo.findAll();
		List<Map<String, Object>> resultList = new ArrayList<>();
		for (Feedbacks feedback : feedbackList) {
			Map<String, Object> resultMap = new HashMap<>();
			resultMap.put("text", feedback.getText());
			resultMap.put("fingerprint", feedback.getFingerprint());
			resultMap.put("id", feedback.getId());
			resultMap.put("apiKey", feedback.getApiKey());
			resultMap.put("type", feedback.getType());
			resultMap.put("device", feedback.getDevice());
			resultMap.put("page", feedback.getPage());
			resultList.add(resultMap);
		}
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("results", resultList);
		Map<String, Integer> paginationMap = new HashMap<>();
		paginationMap.put("offset", 0);
		paginationMap.put("limit", resultList.size());
		paginationMap.put("total", feedbackList.size());
		resultMap.put("pagination", paginationMap);
		return resultMap;

	}

}
