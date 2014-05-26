package com.google.code.stackexchange.schema;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sanjiv.Singh
 *
 */
public enum StackExchangeSite implements ValueEnum {

	STACK_OVERFLOW("stackoverflow"), SERVER_FAULT("serverfault"), SUPER_USER(
			"superuser"), META_STACK_OVERFLOW("meta.stackoverflow"), WEB_APPLICATIONS(
			"webapps"), WEB_APPLICATIONS_META("meta.webapps"), ARQADE("gaming"), ARQADE_META(
			"meta.gaming"), WEBMASTERS("webmasters"), WEBMASTERS_META(
			"meta.webmasters"), SEASONED_ADVICE("cooking"), SEASONED_ADVICE_META(
			"meta.cooking"), GAME_DEVELOPMENT("gamedev"), GAME_DEVELOPMENT_META(
			"meta.gamedev"), PHOTOGRAPHY("photo"), PHOTOGRAPHY_META(
			"meta.photo"), CROSS_VALIDATED("stats"), CROSS_VALIDATED_META(
			"meta.stats"), MATHEMATICS("math"), MATHEMATICS_META("meta.math"), HOME_IMPROVEMENT(
			"diy"), HOME_IMPROVEMENT_META("meta.diy"), META_SUPER_USER(
			"meta.superuser"), META_SERVER_FAULT("meta.serverfault"), GEOGRAPHIC_INFORMATION_SYSTEMS(
			"gis"), GEOGRAPHIC_INFORMATION_SYSTEMS_META("meta.gis"), TEX_LATEX(
			"tex"), TEX_LATEX_META("meta.tex"), ASK_UBUNTU("askubuntu"), ASK_UBUNTU_META(
			"meta.askubuntu"), PERSONAL_FINANCE_MONEY("money"), PERSONAL_FINANCE_MONEY_META(
			"meta.money"), ENGLISH_LANGUAGE_USAGE("english"), ENGLISH_LANGUAGE_USAGE_META(
			"meta.english"), STACK_APPS("stackapps"), USER_EXPERIENCE("ux"), USER_EXPERIENCE_META(
			"meta.ux"), UNIX_LINUX("unix"), UNIX_LINUX_META("meta.unix"), WORDPRESS_DEVELOPMENT(
			"wordpress"), WORDPRESS_DEVELOPMENT_META("meta.wordpress"), THEORETICAL_COMPUTER_SCIENCE(
			"cstheory"), THEORETICAL_COMPUTER_SCIENCE_META("meta.cstheory"), ASK_DIFFERENT(
			"apple"), ASK_DIFFERENT_META("meta.apple"), ROLE_PLAYING_GAMES(
			"rpg"), ROLE_PLAYING_GAMES_META("meta.rpg"), BICYCLES("bicycles"), BICYCLES_META(
			"meta.bicycles"), PROGRAMMERS("programmers"), PROGRAMMERS_META(
			"meta.programmers"), ELECTRICAL_ENGINEERING("electronics"), ELECTRICAL_ENGINEERING_META(
			"meta.electronics"), ANDROID_ENTHUSIASTS("android"), ANDROID_ENTHUSIASTS_META(
			"meta.android"), BOARD_CARD_GAMES("boardgames"), BOARD_CARD_GAMES_META(
			"meta.boardgames"), PHYSICS("physics"), PHYSICS_META("meta.physics"), HOMEBREWING(
			"homebrew"), HOMEBREWING_META("meta.homebrew"), INFORMATION_SECURITY(
			"security"), INFORMATION_SECURITY_META("meta.security"), WRITERS(
			"writers"), WRITERS_META("meta.writers"), VIDEO_PRODUCTION("video"), VIDEO_PRODUCTION_META(
			"meta.video"), GRAPHIC_DESIGN("graphicdesign"), GRAPHIC_DESIGN_META(
			"meta.graphicdesign"), DATABASE_ADMINISTRATORS("dba"), DATABASE_ADMINISTRATORS_META(
			"meta.dba"), SCIENCE_FICTION_FANTASY("scifi"), SCIENCE_FICTION_FANTASY_META(
			"meta.scifi"), CODE_REVIEW("codereview"), CODE_REVIEW_META(
			"meta.codereview"), PROGRAMMING_PUZZLES_CODE_GOLF("codegolf"), PROGRAMMING_PUZZLES_CODE_GOLF_META(
			"meta.codegolf"), QUANTITATIVE_FINANCE("quant"), QUANTITATIVE_FINANCE_META(
			"meta.quant"), PROJECT_MANAGEMENT("pm"), PROJECT_MANAGEMENT_META(
			"meta.pm"), SKEPTICS("skeptics"), SKEPTICS_META("meta.skeptics"), PHYSICAL_FITNESS(
			"fitness"), PHYSICAL_FITNESS_META("meta.fitness"), DRUPAL_ANSWERS(
			"drupal"), DRUPAL_ANSWERS_META("meta.drupal"), MOTOR_VEHICLE_MAINTENANCE_REPAIR(
			"mechanics"), MOTOR_VEHICLE_MAINTENANCE_REPAIR_META(
			"meta.mechanics"), PARENTING("parenting"), PARENTING_META(
			"meta.parenting"), SHAREPOINT("sharepoint"), SHAREPOINT_META(
			"meta.sharepoint"), MUSICAL_PRACTICE_PERFORMANCE("music"), MUSICAL_PRACTICE_PERFORMANCE_META(
			"meta.music"), SOFTWARE_QUALITY_ASSURANCE_TESTING("sqa"), SOFTWARE_QUALITY_ASSURANCE_TESTING_META(
			"meta.sqa"), MI_YODEYA("judaism"), MI_YODEYA_META("meta.judaism"), GERMAN_LANGUAGE(
			"german"), GERMAN_LANGUAGE_META("meta.german"), JAPANESE_LANGUAGE(
			"japanese"), JAPANESE_LANGUAGE_META("meta.japanese"), PHILOSOPHY(
			"philosophy"), PHILOSOPHY_META("meta.philosophy"), GARDENING_LANDSCAPING(
			"gardening"), GARDENING_LANDSCAPING_META("meta.gardening"), TRAVEL(
			"travel"), TRAVEL_META("meta.travel"), PERSONAL_PRODUCTIVITY(
			"productivity"), PERSONAL_PRODUCTIVITY_META("meta.productivity"), CRYPTOGRAPHY(
			"crypto"), CRYPTOGRAPHY_META("meta.crypto"), SIGNAL_PROCESSING(
			"dsp"), SIGNAL_PROCESSING_META("meta.dsp"), FRENCH_LANGUAGE(
			"french"), FRENCH_LANGUAGE_META("meta.french"), CHRISTIANITY(
			"christianity"), CHRISTIANITY_META("meta.christianity"), BITCOIN(
			"bitcoin"), BITCOIN_META("meta.bitcoin"), LINGUISTICS("linguistics"), LINGUISTICS_META(
			"meta.linguistics"), BIBLICAL_HERMENEUTICS("hermeneutics"), BIBLICAL_HERMENEUTICS_META(
			"meta.hermeneutics"), HISTORY("history"), HISTORY_META(
			"meta.history"), LEGO_ANSWERS("bricks"), LEGO_ANSWERS_META(
			"meta.bricks"), SPANISH_LANGUAGE("spanish"), SPANISH_LANGUAGE_META(
			"meta.spanish"), COMPUTATIONAL_SCIENCE("scicomp"), COMPUTATIONAL_SCIENCE_META(
			"meta.scicomp"), MOVIES_TV("movies"), MOVIES_TV_META("meta.movies"), CHINESE_LANGUAGE(
			"chinese"), CHINESE_LANGUAGE_META("meta.chinese"), BIOLOGY(
			"biology"), BIOLOGY_META("meta.biology"), POKER("poker"), POKER_META(
			"meta.poker"), MATHEMATICA("mathematica"), MATHEMATICA_META(
			"meta.mathematica"), COGNITIVE_SCIENCES("cogsci"), COGNITIVE_SCIENCES_META(
			"meta.cogsci"), THE_GREAT_OUTDOORS("outdoors"), THE_GREAT_OUTDOORS_META(
			"meta.outdoors"), MARTIAL_ARTS("martialarts"), MARTIAL_ARTS_META(
			"meta.martialarts"), SPORTS("sports"), SPORTS_META("meta.sports"), ACADEMIA(
			"academia"), ACADEMIA_META("meta.academia"), COMPUTER_SCIENCE("cs"), COMPUTER_SCIENCE_META(
			"meta.cs"), THE_WORKPLACE("workplace"), THE_WORKPLACE_META(
			"meta.workplace"), WINDOWS_PHONE("windowsphone"), WINDOWS_PHONE_META(
			"meta.windowsphone"), CHEMISTRY("chemistry"), CHEMISTRY_META(
			"meta.chemistry"), CHESS("chess"), CHESS_META("meta.chess"), RASPBERRY_PI(
			"raspberrypi"), RASPBERRY_PI_META("meta.raspberrypi"), RUSSIAN_LANGUAGE(
			"russian"), RUSSIAN_LANGUAGE_META("meta.russian"), ISLAM("islam"), ISLAM_META(
			"meta.islam"), SALESFORCE("salesforce"), SALESFORCE_META(
			"meta.salesforce"), ASK_PATENTS("patents"), ASK_PATENTS_META(
			"meta.patents"), GENEALOGY_FAMILY_HISTORY("genealogy"), GENEALOGY_FAMILY_HISTORY_META(
			"meta.genealogy"), ROBOTICS("robotics"), ROBOTICS_META(
			"meta.robotics"), EXPRESSIONENGINE_ANSWERS("expressionengine"), EXPRESSIONENGINE_ANSWERS_META(
			"meta.expressionengine"), POLITICS("politics"), POLITICS_META(
			"meta.politics"), ANIME_MANGA("anime"), ANIME_MANGA_META(
			"meta.anime"), MAGENTO("magento"), MAGENTO_META("meta.magento"), ENGLISH_LANGUAGE_LEARNERS(
			"ell"), ENGLISH_LANGUAGE_LEARNERS_META("meta.ell"), SUSTAINABLE_LIVING(
			"sustainability"), SUSTAINABLE_LIVING_META("meta.sustainability"), TRIDION(
			"tridion"), TRIDION_META("meta.tridion"), REVERSE_ENGINEERING(
			"reverseengineering"), REVERSE_ENGINEERING_META(
			"meta.reverseengineering"), NETWORK_ENGINEERING(
			"networkengineering"), NETWORK_ENGINEERING_META(
			"meta.networkengineering"), OPEN_DATA("opendata"), OPEN_DATA_META(
			"meta.opendata"), FREELANCING("freelancing"), FREELANCING_META(
			"meta.freelancing"), BLENDER("blender"), BLENDER_META(
			"meta.blender"), MATHOVERFLOW("mathoverflow.net"), MATHOVERFLOW_META(
			"meta.mathoverflow.net"), SPACE_EXPLORATION("space"), SPACE_EXPLORATION_META(
			"meta.space"), SOUND_DESIGN("sound"), SOUND_DESIGN_META(
			"meta.sound"), ASTRONOMY("astronomy"), ASTRONOMY_META(
			"meta.astronomy"), TOR("tor"), TOR_META("meta.tor"), PETS("pets"), PETS_META(
			"meta.pets"), AMATEUR_RADIO("ham"), AMATEUR_RADIO_META("meta.ham"), ITALIAN_LANGUAGE(
			"italian"), ITALIAN_LANGUAGE_META("meta.italian"), STACK_OVERFLOW_EM_PORTUGUES(
			"pt.stackoverflow"), STACK_OVERFLOW_EM_PORTUGUES_META(
			"meta.pt.stackoverflow"), AVIATION("aviation"), AVIATION_META(
			"meta.aviation"), EBOOKS("ebooks"), EBOOKS_META("meta.ebooks"), BEER(
			"beer"), BEER_META("meta.beer"), SOFTWARE_RECOMMENDATIONS(
			"softwarerecs"), SOFTWARE_RECOMMENDATIONS_META("meta.softwarerecs"), ARDUINO(
			"arduino"), ARDUINO_META("meta.arduino"), EXPATRIATES("expatriates"), EXPATRIATES_META(
			"meta.expatriates"), MATHEMATICS_EDUCATORS("matheducators"), MATHEMATICS_EDUCATORS_META(
			"meta.matheducators");

	/** The Constant stringToEnum. */
	private static final Map<String, StackExchangeSite> stringToEnum = new HashMap<String, StackExchangeSite>();

	static { // Initialize map from constant name to enum constant
		for (StackExchangeSite op : values()) {
			stringToEnum.put(op.value(), op);
		}
	}

	/** The value. */
	private final String value;

	/**
	 * Instantiates a new Stack Exchange Site.
	 * 
	 * @param value
	 *            the value
	 */
	StackExchangeSite(String value) {
		this.value = value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.stackexchange.schema.ValueEnum#value()
	 */
	@Override
	public String value() {
		return value;
	}

	/**
	 * From value.
	 * 
	 * @param value
	 *            the value
	 * 
	 * @return the badge rank
	 */
	public static StackExchangeSite fromValue(String value) {
		return stringToEnum.get(value);
	}
}