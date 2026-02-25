import userContext from "../context/userContext";
import Base from "../components/Base";

const Services = () => {
  return (
    <userContext.Consumer>
      {(object) => (
        <Base>
          <div style={styles.container}>
            {/* Page Header */}
            <h1 style={styles.title}>Our Services</h1>
            <p style={styles.subtitle}>
              Powerful features designed to make blogging simple, fast, and effective.
            </p>

            {/* Services Grid */}
            <div style={styles.grid}>
              <div style={styles.card}>
                <h3>✍️ Content Creation</h3>
                <p>
                  Write, edit, and publish blogs with a clean and intuitive editor
                  designed for productivity.
                </p>
              </div>

              <div style={styles.card}>
                <h3>🔐 User Authentication</h3>
                <p>
                  Secure login and registration system to protect user data and
                  manage personalized content.
                </p>
              </div>

              <div style={styles.card}>
                <h3>📂 Category Management</h3>
                <p>
                  Organize blogs by categories so readers can easily explore
                  topics they care about.
                </p>
              </div>

              <div style={styles.card}>
                <h3>⚡ Fast & Responsive</h3>
                <p>
                  Optimized UI that works smoothly across mobile, tablet, and
                  desktop devices.
                </p>
              </div>
            </div>

            {/* User Section */}
            {object?.user?.login && (
              <div style={styles.userBox}>
                <h3>👋 Hello, {object.user.data.name}</h3>
                <p>
                  You can access all our premium blogging features and manage
                  your posts efficiently.
                </p>
              </div>
            )}
          </div>
        </Base>
      )}
    </userContext.Consumer>
  );
};

export default Services;

/* Inline styles */
const styles = {
  container: {
    maxWidth: "1000px",
    margin: "0 auto",
    padding: "40px 20px",
  },
  title: {
    fontSize: "36px",
    textAlign: "center",
    marginBottom: "10px",
  },
  subtitle: {
    fontSize: "18px",
    color: "#555",
    textAlign: "center",
    marginBottom: "40px",
  },
  grid: {
    display: "grid",
    gridTemplateColumns: "repeat(auto-fit, minmax(220px, 1fr))",
    gap: "20px",
  },
  card: {
    backgroundColor: "#ffffff",
    padding: "20px",
    borderRadius: "10px",
    boxShadow: "0 4px 12px rgba(0,0,0,0.1)",
  },
  userBox: {
    marginTop: "40px",
    padding: "20px",
    backgroundColor: "#f1f5f9",
    borderRadius: "8px",
    textAlign: "center",
  },
};