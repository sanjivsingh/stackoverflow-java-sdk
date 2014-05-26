/*
 * Copyright 2010 Nabeel Mukhtar 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 *  http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 * 
 */
package com.google.code.stackexchange.client.query;

import java.util.List;

import com.google.code.stackexchange.common.PagedList;
import com.google.code.stackexchange.schema.Answer;
import com.google.code.stackexchange.schema.Paging;
import com.google.code.stackexchange.schema.Range;

/**
 * The Interface AnswerApiQuery.
 */
public interface AnswerApiQuery extends StackExchangeApiQuery<Answer> {

	/**
	 * List by users.
	 * 
	 * @return the paged list< answer>
	 */
	public PagedList<Answer> listByUsers();

	/**
	 * List by questions.
	 * 
	 * @return the paged list< answer>
	 */
	public PagedList<Answer> listByQuestions();

	/**
	 * With answer ids.
	 * 
	 * @param answerIds
	 *            the answer ids
	 * 
	 * @return the answer api query
	 */
	public AnswerApiQuery withAnswerIds(long... answerIds);

	/**
	 * With answer ids.
	 * 
	 * @param answerIds
	 *            the answer ids
	 * 
	 * @return the answer api query
	 */
	public AnswerApiQuery withAnswerIds(List<Long> answerIds);

	/**
	 * With user ids.
	 * 
	 * @param userIds
	 *            the user ids
	 * 
	 * @return the answer api query
	 */
	public AnswerApiQuery withUserIds(long... userIds);

	/**
	 * With user ids.
	 * 
	 * @param userIds
	 *            the user ids
	 * 
	 * @return the answer api query
	 */
	public AnswerApiQuery withUserIds(List<Long> userIds);

	/**
	 * With question ids.
	 * 
	 * @param questionIds
	 *            the question ids
	 * 
	 * @return the answer api query
	 */
	public AnswerApiQuery withQuestionIds(long... questionIds);

	/**
	 * With question ids.
	 * 
	 * @param questionIds
	 *            the question ids
	 * 
	 * @return the answer api query
	 */
	public AnswerApiQuery withQuestionIds(List<Long> questionIds);

	/**
	 * With sort.
	 * 
	 * @param sort
	 *            the sort
	 * 
	 * @return the answer api query
	 */
	public AnswerApiQuery withSort(Answer.SortOrder sort);

	/**
	 * With range.
	 * 
	 * @param range
	 *            the range
	 * 
	 * @return the answer api query
	 */
	public AnswerApiQuery withRange(Range range);

	/**
	 * With paging.
	 * 
	 * @param paging
	 *            the paging
	 * 
	 * @return the question api query
	 */
	public AnswerApiQuery withPaging(Paging paging);
	
	public AnswerApiQuery withFilter(String filter);

	public PagedList<Answer> listByIds();

	public PagedList<Answer> listTopUserAnswersByTag();

	public PagedList<Answer> listMyAnswers();

	public PagedList<Answer> listMyTopAnswersWithTag();



}
