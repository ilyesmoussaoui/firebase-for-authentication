package com.ilyes.firebaseauth.di;

import com.ilyes.firebaseauth.domain.repository.AuthRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class AppModule_ProvideAuthRepositoryFactory implements Factory<AuthRepository> {
  private final AppModule module;

  public AppModule_ProvideAuthRepositoryFactory(AppModule module) {
    this.module = module;
  }

  @Override
  public AuthRepository get() {
    return provideAuthRepository(module);
  }

  public static AppModule_ProvideAuthRepositoryFactory create(AppModule module) {
    return new AppModule_ProvideAuthRepositoryFactory(module);
  }

  public static AuthRepository provideAuthRepository(AppModule instance) {
    return Preconditions.checkNotNullFromProvides(instance.provideAuthRepository());
  }
}
