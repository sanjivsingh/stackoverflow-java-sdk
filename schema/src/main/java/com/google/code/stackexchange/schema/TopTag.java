package com.google.code.stackexchange.schema;

/**
 * @author Sanjiv.Singh
 *
 */
public class TopTag extends SchemaEntity {

	private long answerCount;
	private long answerScore;
	private long questionScore;
	private long tagSame;
	private long userId;

	public long getAnswerCount() {
		return answerCount;
	}

	public void setAnswerCount(long answerCount) {
		this.answerCount = answerCount;
	}

	public long getAnswerScore() {
		return answerScore;
	}

	public void setAnswerScore(long answerScore) {
		this.answerScore = answerScore;
	}

	public long getQuestionScore() {
		return questionScore;
	}

	public void setQuestionScore(long questionScore) {
		this.questionScore = questionScore;
	}

	public long getTagSame() {
		return tagSame;
	}

	public void setTagSame(long tagSame) {
		this.tagSame = tagSame;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

}
