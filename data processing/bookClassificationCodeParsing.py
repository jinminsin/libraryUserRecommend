# %%

import pandas as pd

dir_path = 'C:\\Users\\OhSeungHwan\\Documents\\GitHub\\libraryUserRecommendation\\data processing'
file_name = '\\서울특별시 동작구 보유도서(KOLAS, KLAS) 목록_20200731.csv'

# 그냥 read하니 첫줄이 분류 명이라 깨짐. engine='python'을 추가하여 인식
# 259194 x 10 data
data = pd.read_csv(dir_path + file_name, sep=',', engine='python')
print(data.columns)

# 필요한 열만 추출
data_sample = data.loc[:, ['등록번호','서명','발행자','저자','청구기호','ISBN']]

# 해당 열에서 숫자가 나올때마다 문자열 data를 숫자를 기준으로 split
split_df = data_sample['청구기호'].str.split('(\d+)', expand=True)

# 파싱된 문자열 기존 data frame에 update
# index 1이 처음으로 나온 3자리 숫자
data_sample['청구기호'] = split_df[1]
print(data_sample.head(10))
# print(split_df[1].head(10))

save_name = '\\파싱된 도서관 책 보유장서 DB.csv'
# 저장
data_sample.to_csv(dir_path + save_name, sep=',', encoding='euc-kr')