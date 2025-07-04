<p align="center">
    <img src="img/readme/logo.svg"/>
</p>

<p align="center">
    <a href="README.md">中文</a> | <a href="README_EN.md">English</a> | <a href="README_JP.md">日本語</a>
</p>

<p align="center">
    <a href="https://github.com/fast-excel/fastexcel/actions/workflows/ci.yml"><img alt="GitHub Actions Workflow Status" src="https://img.shields.io/github/actions/workflow/status/fast-excel/fastexcel/ci.yml?style=flat-square&logo=github"></a>
    <a href="https://github.com/fast-excel/fastexcel/blob/main/LICENSE"><img alt="GitHub License" src="https://img.shields.io/github/license/fast-excel/fastexcel?logo=apache&style=flat-square"></a>
    <a href="https://mvnrepository.com/artifact/cn.idev.excel/fastexcel"><img alt="Maven Central Version" src="https://img.shields.io/maven-central/v/cn.idev.excel/fastexcel?logo=apachemaven&style=flat-square"></a>
</p>

## What is FastExcel

FastExcel is the latest work created by the original author of EasyExcel. After I left Alibaba in 2023, and with Alibaba announcing the cessation of EasyExcel updates, I decided to continue maintaining and upgrading this project. When restarting, I chose the name FastExcel to emphasize the high performance of this framework when handling Excel files, not just its simplicity and ease of use.

FastExcel will always be free and open source , use the business-friendly Apache license., making it suitable for any commercial scenarios. This provides developers and enterprises with great freedom and flexibility. Some notable features of FastExcel include:

- Full compatibility with all functionalities and features of the original EasyExcel, allowing users to transition seamlessly.
- Migrating from EasyExcel to FastExcel only requires a simple change of package name and Maven dependency to complete the upgrade.
- Functionally, it offers more innovations and improvements than EasyExcel.
- The FastExcel 1.0.0 version introduced the ability to read a specified number of Excel rows and convert Excel to PDF.

We plan to introduce more new features in the future to continually enhance user experience and tool usability. Stay tuned to "Programmer Xiao Lan's" public account for updates on the development of FastExcel. FastExcel is committed to being your best choice for handling Excel files.

## Features

- **High-performance Reading and Writing**: FastExcel focuses on performance optimization, capable of efficiently handling large-scale Excel data. Compared to some traditional Excel processing libraries, it can significantly reduce memory consumption.
- **Simplicity and Ease of Use**: The library offers a simple and intuitive API, allowing developers to easily integrate it into projects, whether for simple Excel operations or complex data processing.
- **Stream Operations**: FastExcel supports stream reading, minimizing the problem of loading large amounts of data at once. This design is especially important when dealing with hundreds of thousands or even millions of rows of data.

## Installation

The following table lists the minimum Java language version requirements for each version of the FastExcel library:

| Version | JDK Version Support Range | Notes                          |
|---------|:-------------------------:|--------------------------------|
| 1.2.x   | JDK8 - JDK21              | Current master branch, fully compatible with EasyExcel |
| 1.1.x   | JDK8 - JDK21              | Current master branch, fully compatible with EasyExcel |
| 1.0.x   | JDK8 - JDK21              | Current master branch, fully compatible with EasyExcel |

We strongly recommend using the latest version of FastExcel, as performance optimizations, bug fixes, and new features in the latest version will enhance your experience.

> Currently, FastExcel uses POI as its underlying package. If your project already includes POI-related components, you will need to manually exclude POI-related jar files.

### Version Update
For detailed update logs, refer to [Details of version updates](./CHANGELOG.md). You can also find all available versions in the [Maven Central Repository](https://mvnrepository.com/artifact/cn.idev.excel/fastexcel).


### Maven

If you are using Maven for project building, add the following configuration in the `pom.xml` file:
```xml
<dependency>
    <groupId>cn.idev.excel</groupId>
    <artifactId>fastexcel</artifactId>
    <version>version</version>
</dependency>
```
### Gradle
If you are using Gradle for project building, add the following configuration in the build.gradle file:

```gradle
dependencies {
    implementation 'cn.idev.excel:fastexcel:version'
}
```

## EasyExcel and FastExcel

### Differences

- FastExcel supports all the features of EasyExcel but with better performance and stability.
- FastExcel has an identical API to EasyExcel, allowing seamless switching.
- FastExcel will continue to update, fix bugs, optimize performance, and add new features.

### How to Upgrade from EasyExcel to FastExcel

#### Update Dependencies
Replace the EasyExcel dependency with the FastExcel dependency, as follows:

```xml
<!-- EasyExcel dependency -->
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>easyexcel</artifactId>
    <version>xxx</version>
</dependency>
```
Replace with:
```xml
<dependency>
    <groupId>cn.idev.excel</groupId>
    <artifactId>fastexcel</artifactId>
    <version>xxx</version>
</dependency>
```
#### Update Code
Replace the EasyExcel package name with the FastExcel package name, as follows:

```java
// Replace EasyExcel package name with FastExcel package name
import com.alibaba.excel.*;
```

Replace with:

```java
import cn.idev.excel.*;
```

### Import FastExcel Without Modifying Code
If you do not want to modify the code for various reasons, you can directly depend on FastExcel by directly adding the dependency in the pom.xml file. EasyExcel and FastExcel can coexist, but long-term switching to FastExcel is recommended.

### Future Use of FastExcel Classes Recommended
To maintain compatibility, EasyExcel classes are retained, but using FastExcel classes in the future is recommended. FastExcel classes are the entry classes for FastExcel and encompass all features of EasyExcel. New features will only be added to FastExcel classes.

## Example

###  Reading Excel Files

Below is an example of reading an Excel document:
```java
// Implement the ReadListener interface to set up operations for reading data
public class DemoDataListener implements ReadListener<DemoData> {
    @Override
    public void invoke(DemoData data, AnalysisContext context) {
        System.out.println("Parsed a data entry" + JSON.toJSONString(data));
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        System.out.println("All data parsed!");
    }
}

public static void main(String[] args) {
    String fileName = "demo.xlsx";
    // Read Excel file
    FastExcel.read(fileName, DemoData.class, new DemoDataListener()).sheet().doRead();
}
```

### Creating Excel Files

Below is a simple example of creating an Excel document:
```java
// Sample data class
public class DemoData {
    @ExcelProperty("String Title")
    private String string;
    @ExcelProperty("Date Title")
    private Date date;
    @ExcelProperty("Number Title")
    private Double doubleData;
    @ExcelIgnore
    private String ignore;
}

// Prepare data to write
private static List<DemoData> data() {
    List<DemoData> list = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
        DemoData data = new DemoData();
        data.setString("String" + i);
        data.setDate(new Date());
        data.setDoubleData(0.56);
        list.add(data);
    }
    return list;
}

public static void main(String[] args) {
    String fileName = "demo.xlsx";
    // Create a "Template" sheet and write data
    FastExcel.write(fileName, DemoData.class).sheet("Template").doWrite(data());
}
```

## Contributing
Contributors are welcomed to join the FastExcel project. Please check [Contributing Guide](./CONTRIBUTING.md) about how to contribute to this project.

Thank you to all the people who already contributed to FastExcel!

<a href="https://github.com/fast-excel/fastexcel/graphs/contributors">
  <img src="https://contrib.rocks/image?repo=fast-excel/fastexcel"/>
</a>

> Note: Showing the first 100 contributors only due to GitHub image size limitations

## Star History

[![Star History Chart](https://api.star-history.com/svg?repos=fast-excel/fastexcel&type=Date)](https://www.star-history.com/#fast-excel/fastexcel&Date)

## License

The project is licensed under the [Apache License 2.0](https://github.com/fast-excel/fastexcel/blob/main/LICENSE).

