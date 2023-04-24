package com.igor.feedbacker.services.interfaces;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.igor.feedbacker.entities.Feedbacks;

public interface FeedbacksServicesInterface {
	
	public Map<String, Object> buscarTodos();
	public Feedbacks novoFeedback(Feedbacks obj);
	public void deletarFeedback(String id);
	public Optional<Feedbacks> buscaPorId(String id);
	public List<Feedbacks> buscarPorTipo(String tipo);
	public Map<String, Object> buscarTodosPorId(String id);
}
