import pandas as pd

# Load dataset (example: Titanic)
df = pd.read_csv(r"Titanic-Dataset.csv")   # replace with your dataset path


print(df.head())
print("............................")      
print(df.info())
print("............................")          
print(df.describe())
print("............................")       
print(df.isnull().sum())
print("............................")     

print("MISSING VALUES HANDLING")

# Fill numeric columns with median
for col in df.select_dtypes(include=['float64', 'int64']).columns:
    df[col] = df[col].fillna(df[col].median())
print(df[col])    
print("............................")
# Fill categorical columns with mode
for col in df.select_dtypes(include=['object']).columns:
    df[col] = df[col].fillna(df[col].mode()[0])
print(df[col])
print("............................")


print("ENCODE CATEGORICAL VARIABLES")
from sklearn.preprocessing import LabelEncoder

encoder = LabelEncoder()
for col in df.select_dtypes(include=['object']).columns:
    df[col] = encoder.fit_transform(df[col])
print(df[col])
print("............................")

print("FEATURE SCALING")
from sklearn.preprocessing import StandardScaler

scaler = StandardScaler()
num_cols = df.select_dtypes(include=['int64','float64']).columns
df[num_cols] = scaler.fit_transform(df[num_cols])
print(df[num_cols])
print("............................")
print("outlier DETECTION AND REMOVAL")
import seaborn as sns
import matplotlib.pyplot as plt

for col in num_cols:
    sns.boxplot(x=df[col])
    plt.show()
    
    Q1 = df[col].quantile(0.25)
    Q3 = df[col].quantile(0.75)
    IQR = Q3 - Q1
    lower = Q1 - 1.5*IQR
    upper = Q3 + 1.5*IQR
    df = df[(df[col] >= lower) & (df[col] <= upper)]

