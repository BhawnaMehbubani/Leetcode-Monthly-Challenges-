{\rtf1\ansi\ansicpg1252\cocoartf2709
\cocoatextscaling0\cocoaplatform0{\fonttbl\f0\fswiss\fcharset0 Helvetica;}
{\colortbl;\red255\green255\blue255;}
{\*\expandedcolortbl;;}
\paperw11900\paperh16840\margl1440\margr1440\vieww28600\viewh17440\viewkind0
\pard\tx720\tx1440\tx2160\tx2880\tx3600\tx4320\tx5040\tx5760\tx6480\tx7200\tx7920\tx8640\pardirnatural\partightenfactor0

\f0\fs24 \cf0 class Solution \{\
  public int minExtraChar(String s, String[] dictionary) \{\
    final int n = s.length();\
    Set<String> dictionarySet = new HashSet<>(Arrays.asList(dictionary));\
    // dp[i] := min extra characters if breaking up s[0:i] optimally\
    int[] dp = new int[n + 1];\
    Arrays.fill(dp, n);\
    dp[0] = 0;\
\
    for (int i = 1; i <= n; i++)\
      for (int j = 0; j < i; j++)\
        // s[j..i) is in dictionarySet.\
        if (dictionarySet.contains(s.substring(j, i)))\
          dp[i] = Math.min(dp[i], dp[j]);\
        // s[j..i) are extra characters.\
        else\
          dp[i] = Math.min(dp[i], dp[j] + i - j);\
\
    return dp[n];\
  \}\
\}}