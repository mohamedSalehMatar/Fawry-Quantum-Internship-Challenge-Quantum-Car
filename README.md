# 🚗 Car Factory System - Fawri Challenge

## Overview

The **Car Factory System** is a sophisticated Java-based application designed to manage and simulate car manufacturing operations. This project was developed as part of the Fawri Challenge, focusing on implementing efficient factory management, production scheduling, and inventory control systems.

## 🎯 Project Goals

- **Simulate real-world car factory operations** with accurate production workflows
- **Manage resources efficiently** including workers, materials, and equipment
- **Track production schedules** and optimize manufacturing timelines
- **Implement scalable architecture** for handling multiple production lines
- **Provide comprehensive reporting** on factory performance metrics

## 📋 Features

- ✅ Factory configuration and setup
- ✅ Production line management
- ✅ Vehicle assembly workflow simulation
- ✅ Resource allocation and tracking
- ✅ Quality control mechanisms
- ✅ Performance analytics and reporting
- ✅ Order management system

## 🛠️ Technology Stack

- **Language**: Java
- **Build System**: IntelliJ IDEA (IML configuration included)
- **Architecture**: Object-Oriented Design
- **Documentation**: Included specifications and design documents

## 📁 Project Structure

```
Car-Factory-System-Fawri-Challenge/
├── src/                          # Source code directory
│   ├── [Java source files]
│   ├── [Classes and interfaces]
│   └── [Utilities and helpers]
├── out/                          # Compiled output
├── .idea/                        # IntelliJ IDEA configuration
├── CarFactory.iml                # IntelliJ IDEA project module file
├── nsquare - quantum car - slope11.pdf  # Specification documents
└── README.md                     # This file
```

## 🚀 Getting Started

### Prerequisites

- Java JDK 11 or higher
- IntelliJ IDEA (recommended) or any Java IDE
- Maven/Gradle (if applicable)

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/mohamedSalehMatar/Car-Factory-System-Fawri-Challenge.git
   cd Car-Factory-System-Fawri-Challenge
   ```

2. **Open in IDE**
   - Open IntelliJ IDEA
   - Select "Open" and navigate to the project directory
   - The IDE will automatically recognize the CarFactory.iml file

3. **Build the project**
   - Right-click on the project → Build Project
   - Or use: `Build` → `Build Project` from the menu

4. **Run the application**
   - Locate the main class in your src folder
   - Right-click and select "Run"

## 📖 Documentation

The project includes detailed specifications in:
- **nsquare - quantum car - slope11.pdf** - Complete requirements and design specifications

## 🏭 Core Components

### Factory Management
- Manages overall factory operations and resource allocation
- Coordinates between different production lines
- Handles scheduling and workflow optimization

### Production Lines
- Individual assembly lines with specific capabilities
- Task sequencing and worker assignment
- Quality checkpoints and validation

### Inventory System
- Tracks raw materials and components
- Manages stock levels
- Handles supply chain integration

### Reporting Module
- Generates production reports
- Provides performance metrics
- Analyzes efficiency and bottlenecks

## 📊 Usage Example

```java
// Initialize the factory
CarFactory factory = new CarFactory();

// Configure production lines
factory.configureLine("Line-A", 50);

// Start production
factory.startProduction();

// Generate reports
factory.generateReport();
```

## 🔧 Configuration

Key configuration parameters can be adjusted in the factory configuration files:
- Production line capacity
- Worker efficiency rates
- Quality control thresholds
- Material delivery schedules

## 📈 Performance Metrics

Monitor the following metrics:
- **Production Rate**: Cars completed per hour
- **Efficiency**: Actual output vs. theoretical maximum
- **Quality Score**: Percentage of defect-free cars
- **Resource Utilization**: Worker and equipment usage rates

## 🐛 Troubleshooting

### Common Issues

**Issue**: Application won't compile
- **Solution**: Ensure Java JDK is properly installed and JAVA_HOME is set

**Issue**: IntelliJ doesn't recognize the project
- **Solution**: Delete `.idea` folder and reimport the project

**Issue**: Build errors
- **Solution**: Clean the project (Build → Clean Project) and rebuild

## 🤝 Contributing

Contributions are welcome! Please:
1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📝 License

This project is provided as-is for the Fawri Challenge. Please refer to the specifications document for additional licensing information.

## 👤 Author

- **Mohamed Saleh Matar** - [GitHub Profile](https://github.com/mohamedSalehMatar)

## 📞 Support

For issues and questions:
- Open an issue on [GitHub Issues](https://github.com/mohamedSalehMatar/Car-Factory-System-Fawri-Challenge/issues)
- Check the specification documents for detailed requirements
- Review existing issues for solutions

## 🔗 Related Resources

- [Specification Document](https://github.com/mohamedSalehMatar/Car-Factory-System-Fawri-Challenge/blob/master/nsquare%20-%20quantum%20car%20-%20slope11.pdf)
- [Java Documentation](https://docs.oracle.com/en/java/)

---

**Last Updated**: April 24, 2026

**Status**: Active Development

**Repository**: [Car-Factory-System-Fawri-Challenge](https://github.com/mohamedSalehMatar/Car-Factory-System-Fawri-Challenge)
