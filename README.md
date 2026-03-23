# 🛒 KRIO – Local Grocery Delivery Platform

KRIO is an Android-based grocery delivery application inspired by platforms like Blinkit and Zepto, with a unique focus on empowering local kirana stores and vendors.

## 🚀 Overview

KRIO connects customers with nearby local grocery stores, enabling faster delivery while supporting small businesses. Instead of relying on centralized warehouses, this platform broadcasts customer orders to nearby vendors, allowing them to accept and fulfill orders efficiently.

## 🧠 Key Idea

When a user places an order:

* The request is broadcast to nearby kirana stores
* Vendors can accept the order based on availability
* The accepted vendor fulfills and delivers the order to the customer

This creates a decentralized, fast, and scalable delivery system.

## 📱 Applications

The system consists of two main applications:

### 1. Customer App

* User authentication (Firebase)
* Browse categories and products
* Add items to cart
* Place orders
* Real-time order tracking (planned)

### 2. Vendor App (Planned / In Progress)

* Receive broadcasted orders
* Accept or reject orders
* Manage inventory (future scope)
* Track and complete deliveries

## 🛠️ Tech Stack

* Kotlin
* Jetpack Compose
* Firebase Authentication
* Firebase Realtime Database / Firestore (planned)
* MVVM Architecture

## 🔥 Features

* Location-based order distribution (concept)
* Fast local delivery model
* Scalable architecture for multiple vendors
* Clean and modern UI using Jetpack Compose

## 🎯 Future Enhancements

* Real-time order tracking with maps
* Payment integration (UPI / Razorpay)
* Vendor rating system
* Smart vendor selection (based on distance & availability)
* Notifications for order updates

## ⚠️ Note

`google-services.json` is excluded from this repository for security reasons.
Please add your own Firebase configuration file to run the project.

## 🤝 Vision

The goal of KRIO is to digitize local kirana stores and provide them with a platform to compete with large-scale delivery services while maintaining fast and efficient service for customers.

---
