import { z } from "zod";
import { googleResp } from ".";

export const sourceIdActivity =
  "derived:com.google.activity.segment:com.google.android.gms:merge_activity_segments";
export const sourceIdActiveMinutes =
  "derived:com.google.active_minutes:com.google.android.gms:merge_active_minutes";
export const sourceIdDistance =
  "derived:com.google.distance.delta:com.google.android.gms:merge_distance_delta";
export const sourceIdCalories =
  "derived:com.google.calories.expended:com.google.android.gms:merge_calories_expended";
export const sourceIdSteps =
  "derived:com.google.step_count.delta:com.google.android.gms:estimated_steps";
export const sourceIdSpeed = "derived:com.google.speed:com.google.android.gms:merge_speed";

export const googleActivityDataSourceId = z.enum([
  sourceIdActivity,
  sourceIdActiveMinutes,
  sourceIdCalories,
  sourceIdDistance,
  sourceIdSteps,
  sourceIdSpeed,
]);

export const googleActivityResp = googleResp(googleActivityDataSourceId);

export type GoogleActivity = z.infer<typeof googleActivityResp>;
export type GoogleActivityDataSourceId = z.infer<typeof googleActivityDataSourceId>;

export const GoogleActivityTypes: { [index: number]: string } = {
  9: "Aerobics",
  119: "Archery",
  10: "Badminton",
  11: "Baseball",
  12: "Basketball",
  13: "Biathlon",
  1: "Biking",
  14: "Handbiking",
  15: "Mountain biking",
  16: "Road biking",
  17: "Spinning",
  18: "Stationary biking",
  19: "Utility biking",
  20: "Boxing",
  21: "Calisthenics",
  22: "Circuit training",
  23: "Cricket",
  113: "Crossfit",
  106: "Curling",
  24: "Dancing",
  102: "Diving",
  117: "Elevator",
  25: "Elliptical",
  103: "Ergometer",
  118: "Escalator",
  26: "Fencing",
  27: "Football (American)",
  28: "Football (Australian)",
  29: "Football (Soccer)",
  30: "Frisbee",
  31: "Gardening",
  32: "Golf",
  122: "Guided Breathing",
  33: "Gymnastics",
  34: "Handball",
  114: "HIIT",
  35: "Hiking",
  36: "Hockey",
  37: "Horseback riding",
  38: "Housework",
  104: "Ice skating",
  0: "In vehicle",
  115: "Interval Training",
  39: "Jumping rope",
  40: "Kayaking",
  41: "Kettlebell training",
  42: "Kickboxing",
  43: "Kitesurfing",
  44: "Martial arts",
  45: "Meditation",
  46: "Mixed martial arts",
  108: "Other (unclassified fitness activity)",
  47: "P90X exercises",
  48: "Paragliding",
  49: "Pilates",
  50: "Polo",
  51: "Racquetball",
  52: "Rock climbing",
  53: "Rowing",
  54: "Rowing machine",
  55: "Rugby",
  8: "Running",
  56: "Jogging",
  57: "Running on sand",
  58: "Running (treadmill)",
  59: "Sailing",
  60: "Scuba diving",
  61: "Skateboarding",
  62: "Skating",
  63: "Cross skating",
  105: "Indoor skating",
  64: "Inline skating (rollerblading)",
  65: "Skiing",
  66: "Back-country skiing",
  67: "Cross-country skiing",
  68: "Downhill skiing",
  69: "Kite skiing",
  70: "Roller skiing",
  71: "Sledding",
  73: "Snowboarding",
  74: "Snowmobile",
  75: "Snowshoeing",
  120: "Softball",
  76: "Squash",
  77: "Stair climbing",
  78: "Stair-climbing machine",
  79: "Stand-up paddleboarding",
  3: "Still (not moving)",
  80: "Strength training",
  81: "Surfing",
  82: "Swimming",
  84: "Swimming (open water)",
  83: "Swimming (swimming pool)",
  85: "Table tennis (ping pong)",
  86: "Team sports",
  87: "Tennis",
  5: "Tilting (sudden device gravity change)",
  88: "Treadmill (walking or running)",
  4: "Unknown (unable to detect activity)",
  89: "Volleyball",
  90: "Volleyball (beach)",
  91: "Volleyball (indoor)",
  92: "Wakeboarding",
  7: "Walking",
  93: "Walking (fitness)",
  94: "Nording walking",
  95: "Walking (treadmill)",
  116: "Walking (stroller)",
  96: "Waterpolo",
  97: "Weightlifting",
  98: "Wheelchair",
  99: "Windsurfing",
  100: "Yoga",
  101: "Zumba",
};