cmake_minimum_required(VERSION 3.10)

project(Lab1)

find_package(GTest REQUIRED)

set(SOURCES
    src/App.cpp
    test/AppTest.cpp
)

add_executable(test ${SOURCES})

target_link_libraries(test GTest::GTest GTest::Main pthread)